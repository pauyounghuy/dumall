package com.byh.mall.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.byh.mall")
@PropertySource(value = {"classpath:config/cache.yml", "file:${spring.profiles.path}/cache.yml"}, encoding = "utf-8",
		ignoreResourceNotFound = true, factory = YamlConfigFactory.class)
public class CacheClientConfig
{
}
