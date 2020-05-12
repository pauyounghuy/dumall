package com.byh.mall.service.impl;
import com.byh.mall.base.BaseService;
import com.byh.mall.dao.CartDAO;
import com.byh.mall.entity.Cart;
import com.byh.mall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImpl extends BaseService implements CartService
{
	@Autowired
	private CartDAO cartDAO;
	@Override
	public List<Cart> getCart(Long userKey)
	{
		return cartDAO.getCart(userKey);
	}
	@Override
	public Cart getCartByKey(Long id)
	{
		return cartDAO.getCartByKey(id);
	}
	@Override
	public void saveCart(Cart cart)
	{
		cartDAO.saveCart(cart);
	}
	@Override
	public void updateCart(Cart cart)
	{
		cartDAO.updateCart(cart);
	}
	@Override
	public void deleteCart(Long id)
	{
		cartDAO.deleteCart(id);
	}
}
