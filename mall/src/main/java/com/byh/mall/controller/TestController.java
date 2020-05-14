package com.byh.mall.controller;
import com.byh.mall.mail.MailService;
import com.byh.mall.utils.RandomUtils;
import commons.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController
{
	@Autowired
	private MailService mailService;

	@RequestMapping("/get")
	public JSONResult get(){
		SimpleMailMessage sm=new SimpleMailMessage();
		sm.setFrom("928828480@qq.com");
		sm.setTo("865967315@qq.com");
		sm.setSubject("测试");
		sm.setText(RandomUtils.random(6).toUpperCase());
		mailService.sendMail(sm);
		return JSONResult.ok();
	}


}
