package com.byh.mall.vo;
import com.byh.mall.entity.Address;
import com.byh.mall.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserInfoVO
{
	private User user;
	List<Address>  addressList=new ArrayList<Address>();
	List<CartVO>  cartList=new ArrayList<CartVO>();
	List<OrderVO>  orderList=new ArrayList<OrderVO>();


	public UserInfoVO()
	{
	}
	public UserInfoVO(User user, List<Address> addressList, List<CartVO> cartList, List<OrderVO> orderList)
	{
		this.user = user;
		this.addressList = addressList;
		this.cartList = cartList;
		this.orderList = orderList;
	}
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public List<Address> getAddressList()
	{
		return addressList;
	}
	public void setAddressList(List<Address> addressList)
	{
		this.addressList = addressList;
	}
	public List<CartVO> getCartList()
	{
		return cartList;
	}
	public void setCartList(List<CartVO> cartList)
	{
		this.cartList = cartList;
	}
	public List<OrderVO> getOrderList()
	{
		return orderList;
	}
	public void setOrderList(List<OrderVO> orderList)
	{
		this.orderList = orderList;
	}
}
