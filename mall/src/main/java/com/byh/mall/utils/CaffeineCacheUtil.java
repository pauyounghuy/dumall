package com.byh.mall.utils;
import com.byh.mall.exception.NoSuchCacheException;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
@DependsOn({"cacheConfig"})
public class CaffeineCacheUtil
{
	@Autowired
	private CacheManager caffeineCacheManager;

	/**
	 * 提取缓存的值
	 *
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public Object getCacheValue(String cacheName, Object key) {

		if (null == caffeineCacheManager.getCache(cacheName)) {
			return null;
		}

		if (null == caffeineCacheManager.getCache(cacheName).get(key)) {
			return null;
		}

		return caffeineCacheManager.getCache(cacheName).get(key).get();
	}

	/**
	 * if cacheName not exists, throw {@link NoSuchCacheException}
	 * <p>
	 * if key not exists, create new CaffeineCache.
	 * key exists, update it.
	 *
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public void putCache(String cacheName, Object key, Object value) {

		Cache cache = caffeineCacheManager.getCache(cacheName);

		if (null == cache) {
			throw new NoSuchCacheException("cache [" + cacheName + "] not exists.");
		}

		CaffeineCache caffeineCache = (CaffeineCache) cache;
		caffeineCache.put(key, value);

	}

	/**
	 * 查询缓存清单
	 *
	 * @return
	 */
	public Collection<String> listCacheNames() {
		return caffeineCacheManager.getCacheNames();
	}

	/**
	 * 查询缓存性能参数
	 *
	 * @return
	 */
	public Map<String, CacheStats> listCachesStats() {
		Map<String, CacheStats> cacheStatses = new HashMap<>();
		Collection<String> cacheNames = listCacheNames();

		cacheNames.forEach(cacheName -> {
			CaffeineCache caffeineCache = (CaffeineCache) caffeineCacheManager.getCache(cacheName);
			com.github.benmanes.caffeine.cache.Cache<Object, Object> cache = caffeineCache.getNativeCache();
			CacheStats cacheStats = cache.stats();
			cacheStatses.put(cacheName, cacheStats);
		});

		return cacheStatses;
	}

	/**
	 * 移除某个缓存
	 * <p>
	 * if cacheName not exists, throw {@link NoSuchCacheException}
	 *
	 * @param cacheName
	 * @param key
	 */
	public void evictCache(String cacheName, Object key) {

		Cache cache = caffeineCacheManager.getCache(cacheName);

		if (null == cache) {
			throw new NoSuchCacheException("cache [" + cacheName + "] not exists.");
		}

		cache.evict(key);
	}

	/**
	 * 清空缓存
	 * <p>
	 * if cacheName not exists, throw {@link NoSuchCacheException}
	 *
	 * @param cacheName
	 */
	public void clearCaches(String cacheName) {

		Cache cache = caffeineCacheManager.getCache(cacheName);

		if (null == cache) {
			throw new NoSuchCacheException("cache [" + cacheName + "] not exists.");
		}

		cache.clear();
	}


}
