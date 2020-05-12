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
@Document(collation = "goods")
@Table(name="GOODS")
public class Goods extends BaseEntity
{
	//主键
	@Id
	@Column(name="ID")
	@JsonProperty("id")
	@Field("productId")
	private Long id;

	@Column(name="PRODUCT_IMAGE")
	@JsonProperty("productImage")
	@Field("productImage")
	private String productImage;  //图片文件名

	@Column(name="PRICE")
	@JsonProperty("price")
	@Field("price")
	private Float price;  //市场价

	@Column(name="FAVOR_PRICE")
	@JsonProperty("favorPrice")
	@Field("favorPrice")
	private Float favorPrice;  //优惠价

	@Column(name="NAME")
	@JsonProperty("name")
	@Field("name")
	private String name;  //商品名

	@Column(name="COUNT")
	@JsonProperty("count")
	@Field("count")
	private Integer count;  //商品数量

	@Column(name="NOTE")
	@JsonProperty("note")
	@Field("note")
	private String note;  //备注描述

	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getProductImage()
	{
		return productImage;
	}
	public void setProductImage(String productImage)
	{
		this.productImage = productImage;
	}
	public Float getPrice()
	{
		return price;
	}
	public void setPrice(Float price)
	{
		this.price = price;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Integer getCount()
	{
		return count;
	}
	public void setCount(Integer count)
	{
		this.count = count;
	}
	public String getNote()
	{
		return note;
	}
	public void setNote(String note)
	{
		this.note = note;
	}
	public Float getFavorPrice()
	{
		return favorPrice;
	}
	public void setFavorPrice(Float favorPrice)
	{
		this.favorPrice = favorPrice;
	}
}
