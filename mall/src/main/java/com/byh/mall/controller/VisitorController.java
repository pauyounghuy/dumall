package com.byh.mall.controller;
import com.byh.mall.base.BaseController;
import com.byh.mall.entity.Visitor;
import com.byh.mall.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/visitor")
public class VisitorController extends BaseController
{
	@Autowired
	private VisitorService visitorService;

	//记录游客
	@RequestMapping("/record")
	public void recordVisitor(HttpServletRequest request, Visitor visitor){
		visitorService.saveVisitor(visitor);
	}

}
