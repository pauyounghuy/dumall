package com.byh.mall.controller;
import com.byh.mall.service.UserService;
import com.byh.mall.utils.RandomUtils;
import commons.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/test")
public class TestController
{
	@Autowired
	private UserService userService;

	@RequestMapping("/get")
	public JSONResult get(){
		return JSONResult.ok(RandomUtils.random(4));
	}


}
