package com.byh.mall.controller;
import com.byh.mall.base.BaseController;
import com.byh.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController
{
	@Autowired
	private OrderService orderService;







}
