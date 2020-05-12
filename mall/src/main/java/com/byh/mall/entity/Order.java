package com.byh.mall.entity;
import com.byh.mall.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Document(collation = "order")
@Table(name="ORDER")
public class Order extends BaseEntity
{
	//主键
	@Id
	@Column(name="ID")
	@JsonProperty("id")
	@Field("orderId")
	private Long id;

	//用户id
	@Column(name="USER_KEY")
	@JsonProperty("userKey")
	@Field("userId")
	private Long userKey;

	//地址id
	@Column(name="ADS_KEY")
	@JsonProperty("adsKey")
	@Field("addressId")
	private Long adsKey;

	//订单状态  0待付款 1已完成 2已关闭
	@Column(name="STATUS")
	@JsonProperty("status")
	@Field("status")
	private int status=0;

	//完成时间
	@Column(name="COMPLETE_DATE")
	@JsonProperty("completeDate")
	@Field("completeDate")
	private String completeDate;

	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public Long getAdsKey()
	{
		return adsKey;
	}
	public void setAdsKey(Long adsKey)
	{
		this.adsKey = adsKey;
	}
	public int getStatus()
	{
		return status;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
	public Long getUserKey()
	{
		return userKey;
	}
	public void setUserKey(Long userKey)
	{
		this.userKey = userKey;
	}
	public String getCompleteDate()
	{
		return completeDate;
	}
	public void setCompleteDate(String completeDate)
	{
		this.completeDate = completeDate;
	}
}
