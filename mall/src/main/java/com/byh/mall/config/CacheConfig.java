package com.byh.mall.config;


import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 初始化缓存管理器
 *
 * @author: wangyong
 * @date: 2020/1/9
 * <p>
 * @description:
 */

@Slf4j
@Configuration
public class CacheConfig {

    /**
     * 创建基于Caffeine的Cache Manager
     * @return
     */
    @Bean
    public CacheManager caffeineCacheManager(){
        Caffeine<Object, Object> caffeine = Caffeine.newBuilder()
                        .initialCapacity(16)
                        .maximumSize(512)
                        .expireAfterWrite(300, TimeUnit.SECONDS )
                        .refreshAfterWrite(100, TimeUnit.SECONDS)
                .recordStats()
                .removalListener((key, value, cause) -> log.debug("缓存键 [{}], 缓存值 [{}] 被淘汰的原因为: [{}]", key, value, cause));

        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setAllowNullValues(true);
        cacheManager.setCaffeine(caffeine);
        cacheManager.setCacheLoader(createCacheLoader());
        cacheManager.setCacheNames(getNames());
        return cacheManager;
    }

    @Bean
    public CacheLoader<Object, Object> createCacheLoader() {
        return new CacheLoader<Object, Object>() {
            @Override
            public Object load(Object key) throws Exception {
                log.debug("cacheLoader load : {}", key);
                return null;
            }
        };
    }

    private Object load(Object key) throws Exception {
        log.debug("cacheLoader load : {}", key);
        return null;
    }

    private static List<String> getNames(){
        List<String> names = new ArrayList<>(2);
        names.add("beanCache");
        names.add("sessionCache");
        return names;
    }

}
