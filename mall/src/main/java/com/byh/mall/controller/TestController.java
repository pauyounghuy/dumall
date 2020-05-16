package com.byh.mall.controller;
import com.byh.mall.base.BaseController;
import com.byh.mall.mail.MailService;
import com.byh.mall.utils.ConfigurationUtils;
import commons.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController
{
	@Autowired
	private MailService mailService;

	@Value("${validator.config}")
	private String config;

	@Autowired
	private Environment environment;

	@RequestMapping("/get")
	public JSONResult get(){
		return JSONResult.ok();
	}
	@RequestMapping("/get2")
	public String getOne(){
		return ConfigurationUtils.getValue("222",new File(config));
	}
	@RequestMapping("/set")
	public JSONResult set(){
		return JSONResult.errorMsg(super.code("222"));
	}

}
