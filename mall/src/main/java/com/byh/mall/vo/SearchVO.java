package com.byh.mall.vo;
public class SearchVO
{
	private Long userKey;
	private String name;
	private String streetName;
	private Integer status;

	public Integer getStatus()
	{
		return status;
	}
	public void setStatus(Integer status)
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
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getStreetName()
	{
		return streetName;
	}
	public void setStreetName(String streetName)
	{
		this.streetName = streetName;
	}
}
