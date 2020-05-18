package com.byh.mall.dao;
import com.byh.mall.entity.Cart;
import com.byh.mall.entity.OrderGoods;

import java.util.List;

public interface OrderGoodsDAO
{
	List<OrderGoods> getOrder(Long oid);
	OrderGoods getOrderOne(Long id);
	OrderGoods getOrderOne(Long oid,Long gid);
	void saveOrderGoods(OrderGoods orderGoods);
	void deleteOrderGoods(Long id);
	void deleteOrderGoods(Long oid,Long gid);
}
