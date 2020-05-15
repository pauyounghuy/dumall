package com.byh.mall.config;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
@ConditionalOnProperty(prefix = "cache.caffeine-plus", value = "enabled")
@Slf4j
public class CacheConfig
{
	@Autowired
	private CacheProperties cacheProperties;

	/**
	 * 创建基于Caffeine的Cache Manager
	 *
	 * @return
	 */
	@Bean
	@Primary
	public CacheManager caffeineCacheManager() {

		log.debug("caffeine-plus create cacheManager");

		SimpleCacheManager cacheManager = new SimpleCacheManager();
		Map<String, CaffeineCache> cacheMap = new HashMap();

		// 设置全局配置的本地缓存
		List<String> globalCacheNames = cacheProperties.getCacheName();
		if (null != globalCacheNames && !globalCacheNames.isEmpty()) {
			addCacheObject(cacheMap, globalCacheNames, cacheProperties.getSpec());
		}

		// 设置自定义属性缓存, 可以覆盖全局缓存
		List<CacheProperties.Config> configs = cacheProperties.getConfigs();
		if (null != configs && !configs.isEmpty()) {
			for (CacheProperties.Config config : configs) {
				List<String> cacheNames = config.getCacheName();
				if (null == cacheNames || cacheNames.isEmpty()) {
					continue;
				}
				addCacheObject(cacheMap, cacheNames, config.getSpec());
			}
		}
		// 加入到缓存管理器进行管理
		cacheManager.setCaches(cacheMap.values());

		return cacheManager;
	}

	/**
	 * 添加缓存对象
	 * <p>
	 * 不支持refreshAfterWrite参数
	 * refreshAfterWrite参数需要配合cacheLoader使用，需要自定义cacheManager
	 *
	 * @param cacheMap
	 * @param cacheNames
	 * @param caffeineSpec
	 */
	private void addCacheObject(Map<String, CaffeineCache> cacheMap, List<String> cacheNames, String caffeineSpec) {

		for (String cacheName : cacheNames) {

			/**
			 * 初始化caffeine对象
			 */
			Caffeine<Object, Object> caffeine = Caffeine.from(caffeineSpec).recordStats();

			/**
			 * 监听缓存淘汰原因
			 */
			caffeine.removalListener((key, value, cause) -> log.debug("缓存键 [{}], 缓存值 [{}] 被淘汰的原因为: [{}]", key, value, cause));

			/**
			 * 构建caffeine缓存
			 */
			Cache<Object, Object> cache = caffeine.build();
			CaffeineCache caffeineCache = new CaffeineCache(cacheName, cache);

			// 覆盖添加
			cacheMap.put(cacheName, caffeineCache);
		}

	}

}
