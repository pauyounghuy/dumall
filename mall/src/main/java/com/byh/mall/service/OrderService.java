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

	void saveOrder(Order order);
	void deleteOrder(Long id);
	void deleteOrder(Long adsKey, Long userKey);
	void saveOrderGoods(OrderGoods orderGoods);
	void deleteOrderGoods(Long id);
	void deleteOrderGoods(Long oid,Long gid);

	OrderGoods getOrderOne(Long id);
	OrderGoods getOrderOne(Long oid,Long gid);
}
