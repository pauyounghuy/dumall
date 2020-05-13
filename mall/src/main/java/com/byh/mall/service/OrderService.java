package com.byh.mall.service;
import com.byh.mall.entity.Order;
import com.byh.mall.entity.OrderGoods;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService
{
	List<Order> getOrder(Long adsKey,Long userKey);
	Order getOrder(Long id);
	List<OrderGoods> getOgList(Long oid);
	PageInfo<Order> getOrderByPage(SearchVO searchVO, int pageNum, int pageSize);
}
