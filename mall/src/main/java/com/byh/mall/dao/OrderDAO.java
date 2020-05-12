package com.byh.mall.dao;
import com.byh.mall.entity.Order;

import java.util.List;

public interface OrderDAO
{
	List<Order> getOrder(Long adsKey, Long userKey);
	Order getOrder(Long id);
}
