package com.byh.mall.service.impl;
import com.byh.mall.base.BaseService;
import com.byh.mall.entity.Visitor;
import com.byh.mall.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VisitorServiceImpl extends BaseService implements VisitorService
{
	@Autowired
	private MongoTemplate mongoTemplate;
	@Override
	public Visitor getVisitorEnter(String username)
	{
		//倒序获取最新一个是否登录
		Query query = new Query(Criteria.where("username").is(username)).with(Sort.by(Sort.Order.desc("visitTime")));
		List<Visitor> vlist=mongoTemplate.find(query, Visitor.class);
		if(vlist !=null && vlist.size()>0){
			return vlist.get(0);
		}
		else{
			return null;
		}
	}
	@Override
	public void saveVisitor(Visitor visitor)
	{
		mongoTemplate.save(visitor);
	}
}
