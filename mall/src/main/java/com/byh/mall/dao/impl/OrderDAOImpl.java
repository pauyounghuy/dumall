package com.byh.mall.dao.impl;
import com.byh.mall.base.BaseDAO;
import com.byh.mall.dao.OrderDAO;
import com.byh.mall.dao.mapper.OrderMapper;
import com.byh.mall.entity.Order;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class OrderDAOImpl extends BaseDAO implements OrderDAO
{
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public List<Order> getOrder(Long adsKey, Long userKey)
	{
		Example example = new Example(Order.class);
		example.createCriteria().andEqualTo("userKey",userKey).andEqualTo("adsKey", adsKey);
		return orderMapper.selectByExample(example);
	}
	@Override
	public Order getOrder(Long id)
	{
		return orderMapper.selectByPrimaryKey(id);
	}
}
