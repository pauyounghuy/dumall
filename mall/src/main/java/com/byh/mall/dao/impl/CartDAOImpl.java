package com.byh.mall.dao.impl;
import com.byh.mall.base.BaseDAO;
import com.byh.mall.dao.CartDAO;
import com.byh.mall.dao.mapper.CartMapper;
import com.byh.mall.entity.Cart;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class CartDAOImpl extends BaseDAO implements CartDAO
{
	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<Cart> getCart(Long userKey)
	{
		Example example = new Example(Cart.class);
		example.createCriteria().andEqualTo("userKey",userKey);
		return cartMapper.selectByExample(example);
	}
	@Override
	public Cart getCartByKey(Long id)
	{
		return cartMapper.selectByPrimaryKey(id);
	}
	@Override
	public void saveCart(Cart cart)
	{
		cartMapper.insertSelective(cart);
	}
	@Override
	public void updateCart(Cart cart)
	{
		cartMapper.updateByPrimaryKeySelective(cart);
	}
	@Override
	public void deleteCart(Long id)
	{
		cartMapper.deleteByPrimaryKey(id);
	}
}
