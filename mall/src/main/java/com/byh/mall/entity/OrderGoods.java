package com.byh.mall.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderGoods")
public class OrderGoods
{
	//主键
	@Id
	@Column(name="ID")
	@JsonProperty("id")
	private Long id;

	@Column(name="OID")
	@JsonProperty("oid")
	private Long oid;

	@Column(name="GID")
	@JsonProperty("gid")
	private Long gid;

	@Column(name="QTY")
	@JsonProperty("qty")
	private int qty;

	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public Long getOid()
	{
		return oid;
	}
	public void setOid(Long oid)
	{
		this.oid = oid;
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
}
