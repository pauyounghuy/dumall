package com.byh.mall.dao;
import com.byh.mall.entity.Order;
import com.byh.mall.entity.OrderGoods;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface OrderDAO
{
	List<Order> getOrder(Long adsKey, Long userKey);
	Order getOrder(Long id);
	PageInfo<Order> getOrderByCondition(SearchVO searchVO, int pageNum, int pageSize);
	void saveOrder(Order order);
	void updateOrder(Order order);
	void deleteOrder(Long id);
	void deleteOrder(Long adsKey, Long userKey);

}
