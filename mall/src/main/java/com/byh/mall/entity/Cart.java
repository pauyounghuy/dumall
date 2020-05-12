package com.byh.mall.entity;
import com.byh.mall.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart extends BaseEntity
{
	//主键
	@Id
	@Column(name="ID")
	@JsonProperty("id")
	private Long id;

	@Column(name="UID")
	@JsonProperty("uid")
	private Long uid;

	@Column(name="GID")
	@JsonProperty("gid")
	private Long gid;

	@Column(name="QTY")
	@JsonProperty("qty")
	private int qty;

	@Column(name="IS_CHECKED")
	@JsonProperty("isChecked")
	private int isChecked=0;

	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public Long getUid()
	{
		return uid;
	}
	public void setUid(Long uid)
	{
		this.uid = uid;
	}
	public Long getGid()
	{
		return gid;
	}
	public void setGid(Long gid)
	{
		this.gid = gid;
	}
	public int getQty()
	{
		return qty;
	}
	public void setQty(int qty)
	{
		this.qty = qty;
	}
	public int getIsChecked()
	{
		return isChecked;
	}
	public void setIsChecked(int isChecked)
	{
		this.isChecked = isChecked;
	}
}
