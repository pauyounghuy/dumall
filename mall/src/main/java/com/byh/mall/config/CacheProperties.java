package com.byh.mall.config;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConditionalOnProperty(prefix = "cache.caffeine-plus", value = "enabled")
@ConfigurationProperties(prefix = "cache.caffeine-plus")
public class CacheProperties
{
	private List<String> cacheName;
	private List<Config> configs;
	private String spec;

	@Getter
	@Setter
	public static class Config {
		private List<String> cacheName;
		private String spec;
	}

}
