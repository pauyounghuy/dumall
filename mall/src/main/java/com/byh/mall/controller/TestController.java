package com.byh.mall.controller;
import com.byh.mall.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController
{
	@Autowired
	private UserDAO userDAO;

	@RequestMapping("/get")
	public String get(){
		return userDAO.checkUsername("byh").getUsername();
	}


}
