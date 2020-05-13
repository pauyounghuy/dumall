package com.byh.mall.entity;
import com.byh.mall.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address extends BaseEntity
{
	//主键
	@Id
	@Column(name="ID")
	@JsonProperty("id")
	private Long id;

	@Column(name="USER_KEY")
	@JsonProperty("userKey")
	private Long userKey;

	@Column(name="NAME")
	@JsonProperty("name")
	private String name;

	@Column(name="STREET_NAME")
	@JsonProperty("streetName")
	private String streetName;

	@Column(name="POST_CODE")
	@JsonProperty("postcode")
	private String postcode;

	@Column(name="TELEPHONE")
	@JsonProperty("telephone")
	private String telephone;

	//1选中默认  0不选中
	@Column(name="IS_DEFAULT")
	@JsonProperty("isDefault")
	private int isDefault=0;

	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public Long getUserKey()
	{
		return userKey;
	}
	public void setUserKey(Long userKey)
	{
		this.userKey = userKey;
	}
	public String getStreetName()
	{
		return streetName;
	}
	public void setStreetName(String streetName)
	{
		this.streetName = streetName;
	}
	public String getPostcode()
	{
		return postcode;
	}
	public void setPostcode(String postcode)
	{
		this.postcode = postcode;
	}
	public String getTelephone()
	{
		return telephone;
	}
	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}
	public int getIsDefault()
	{
		return isDefault;
	}
	public void setIsDefault(int isDefault)
	{
		this.isDefault = isDefault;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
}
