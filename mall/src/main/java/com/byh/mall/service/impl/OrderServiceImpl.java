package com.byh.mall.service.impl;
import com.byh.mall.base.BaseService;
import com.byh.mall.dao.OrderDAO;
import com.byh.mall.dao.OrderGoodsDAO;
import com.byh.mall.entity.Order;
import com.byh.mall.entity.OrderGoods;
import com.byh.mall.service.OrderService;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl extends BaseService implements OrderService
{
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private OrderGoodsDAO orderGoodsDAO;

	@Override
	public List<Order> getOrder(Long adsKey, Long userKey)
	{
		return orderDAO.getOrder(adsKey, userKey);
	}
	@Override
	public Order getOrder(Long id)
	{
		return orderDAO.getOrder(id);
	}
	@Override
	public List<OrderGoods> getOgList(Long oid)
	{
		return orderGoodsDAO.getOrder(oid);
	}
	@Override
	public PageInfo<Order> getOrderByPage(SearchVO searchVO, int pageNum, int pageSize)
	{
		return orderDAO.getOrderByCondition(searchVO, pageNum, pageSize);
	}
}
