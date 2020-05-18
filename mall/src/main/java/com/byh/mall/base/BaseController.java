package com.byh.mall.base;
import com.byh.mall.response.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseController extends CommonBase
{
	@Autowired
	public JSONResult jsonResult;

//	@Autowired
//	private transient Environment environment;

//	public String code(String key){
//		return ConfigurationUtils.getValue(key, new File(config));
//	}
//	public String code2(String key){    只能主配置文件获取数据
//		return environment.getProperty(key);
//	}
}
