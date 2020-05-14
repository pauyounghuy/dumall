package com.byh.mall.controller;
import com.byh.mall.entity.Goods;
import com.byh.mall.entity.User;
import com.byh.mall.service.GoodsService;
import com.byh.mall.service.UserService;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageInfo;
import commons.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController
{
	@Autowired
	private UserService userService;

	@RequestMapping("/get")
	public JSONResult get(){
		User user=new User("xxx","xd","123","123","111@q.com","9090");
		userService.saveUser(user);
		return JSONResult.ok();
	}


}
