package com.byh.mall.dao;
import com.byh.mall.entity.OrderGoods;

import java.util.List;

public interface OrderGoodsDAO
{
	OrderGoods getOrderOne(Long id);
	List<OrderGoods> getOrder(Long oid);
}
