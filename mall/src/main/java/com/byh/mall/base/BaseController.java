package com.byh.mall.base;
import com.byh.mall.utils.ConfigurationUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class BaseController extends CommonBase
{
	@Value("${validator.config}")
	private transient String config;

//	@Autowired
//	private transient Environment environment;

	public String code(String key){
		return ConfigurationUtils.getValue(key, new File(config));
	}
//	public String code2(String key){
//		return environment.getProperty(key);
//	}
}
