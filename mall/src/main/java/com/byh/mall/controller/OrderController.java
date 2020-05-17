package com.byh.mall.controller;
import com.byh.mall.base.BaseController;
import com.byh.mall.entity.Order;
import com.byh.mall.service.OrderService;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageInfo;
import com.byh.mall.response.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController
{
	@Autowired
	private OrderService orderService;

	//分页显示订单信息
	@RequestMapping("/getByPageCondition")
	public JSONResult getOrderByCondition(HttpServletRequest request, SearchVO searchVO, int pageNum, int pageSize)
	{
		PageInfo<Order> gdsPage = orderService.getOrderByPage(searchVO, pageNum, pageSize);
		return jsonResult.ok(gdsPage);
	}






}
