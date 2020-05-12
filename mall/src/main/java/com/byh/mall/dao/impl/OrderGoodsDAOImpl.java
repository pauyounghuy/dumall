package com.byh.mall.dao.impl;
import com.byh.mall.base.BaseDAO;
import com.byh.mall.dao.OrderGoodsDAO;
import com.byh.mall.dao.mapper.OrderGoodsMapper;
import com.byh.mall.entity.OrderGoods;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class OrderGoodsDAOImpl extends BaseDAO implements OrderGoodsDAO
{
	@Autowired
	private OrderGoodsMapper orderGoodsMapper;
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public OrderGoods getOrderOne(Long id)
	{
		return orderGoodsMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<OrderGoods> getOrder(Long oid)
	{
		Example example=new Example(OrderGoods.class);
		example.createCriteria().andEqualTo("oid", oid);
		return orderGoodsMapper.selectByExample(example);
	}
}
