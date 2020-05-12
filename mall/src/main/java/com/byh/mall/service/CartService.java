package com.byh.mall.service;
import com.byh.mall.entity.Cart;

import java.util.List;

public interface CartService
{
	List<Cart> getCart(Long userKey);
	Cart getCartByKey(Long id);
	void saveCart(Cart cart);
	void updateCart(Cart cart);
	void deleteCart(Long id);
}
