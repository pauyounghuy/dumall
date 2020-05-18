package com.byh.mall.dao.impl;
import com.byh.mall.base.BaseDAO;
import com.byh.mall.dao.OrderDAO;
import com.byh.mall.dao.mapper.OrderMapper;
import com.byh.mall.entity.Address;
import com.byh.mall.entity.Goods;
import com.byh.mall.entity.Order;
import com.byh.mall.entity.OrderGoods;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	@Override
	public PageInfo<Order> getOrderByCondition(SearchVO searchVO, int pageNum, int pageSize)
	{
		Example example = new Example(Order.class);
		example.createCriteria().andEqualTo("status",searchVO.getStatus());
		PageHelper.startPage(pageNum, pageSize);
		List<Order> list = orderMapper.selectByExample(example);
		PageInfo<Order> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	@Override
	public void saveOrder(Order order)
	{
		orderMapper.insertSelective(order);
	}
	@Override
	public void updateOrder(Order order)
	{
		orderMapper.updateByPrimaryKeySelective(order);
	}
	@Override
	public void deleteOrder(Long id)
	{
		orderMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void deleteOrder(Long adsKey, Long userKey)
	{
		Example example=new Example(Order.class);
		example.createCriteria();
		if (adsKey != null && adsKey.longValue()>0l){
			example.and().andEqualTo("adsKey", adsKey);
		}
		if (userKey != null && userKey.longValue()>0l){
			example.and().andEqualTo("userKey", userKey);
		}
		orderMapper.deleteByExample(example);
	}
}
