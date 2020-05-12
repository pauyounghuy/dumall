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
@Document(collation = "user")
@Table(name="user")
public class User extends BaseEntity
{
	//主键
	@Id
	@Column(name="ID")
	@JsonProperty("id")
	@Field("userId")
	private Long id;

	//用户名
	@Column(name="USERNAME")
	@JsonProperty("userName")
	@Field("userName")
	private String username;

	//姓名
	@Column(name="NAME")
	@JsonProperty("name")
	@Field("name")
	private String name;

	//密码
	@Column(name="PASSWORD")
	@JsonProperty("password")
	@Field("userPwd")
	private String password;

	//手机号
	@Column(name="MOBILE")
	@JsonProperty("mobile")
	@Field("mobile")
	private String mobile;

	//email
	@Column(name="EMAIL")
	@JsonProperty("email")
	@Field("email")
	private String email;

	//qq
	@Column(name="QQ")
	@JsonProperty("qq")
	@Field("qq")
	private String qq;

	public User()
	{
	}
	public User(String username, String name, String password, String mobile, String email, String qq)
	{
		this.username = username;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
		this.qq = qq;
	}
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getMobile()
	{
		return mobile;
	}
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getQq()
	{
		return qq;
	}
	public void setQq(String qq)
	{
		this.qq = qq;
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
