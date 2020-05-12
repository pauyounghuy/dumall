package com.byh.mall.vo;
import com.byh.mall.entity.Address;
import com.byh.mall.entity.Goods;

import java.util.List;

public class OrderVO
{
	private String orderId;
	private Integer orderStatus;
	private String createDate;
	private String completeDate;
	private Address addressInfo;
	private List<Goods> goodsList;
	public OrderVO()
	{
	}
	public OrderVO(String orderId, Integer orderStatus, String createDate, String completeDate, Address addressInfo, List<Goods> goodsList)
	{
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.createDate = createDate;
		this.completeDate = completeDate;
		this.addressInfo = addressInfo;
		this.goodsList = goodsList;
	}
	public String getOrderId()
	{
		return orderId;
	}
	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}
	public Integer getOrderStatus()
	{
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus)
	{
		this.orderStatus = orderStatus;
	}
	public String getCreateDate()
	{
		return createDate;
	}
	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}
	public String getCompleteDate()
	{
		return completeDate;
	}
	public void setCompleteDate(String completeDate)
	{
		this.completeDate = completeDate;
	}
	public Address getAddressInfo()
	{
		return addressInfo;
	}
	public void setAddressInfo(Address addressInfo)
	{
		this.addressInfo = addressInfo;
	}
	public List<Goods> getGoodsList()
	{
		return goodsList;
	}
	public void setGoodsList(List<Goods> goodsList)
	{
		this.goodsList = goodsList;
	}
}
