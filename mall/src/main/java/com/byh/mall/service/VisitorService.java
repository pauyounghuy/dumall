package com.byh.mall.service;
import com.byh.mall.entity.Visitor;

public interface VisitorService
{
	//查询游客
	Visitor getVisitorEnter(String username);
	//保存游客
	void saveVisitor(Visitor visitor);
}
