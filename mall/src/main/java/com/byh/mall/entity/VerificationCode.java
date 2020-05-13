package com.byh.mall.entity;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

//发送记录
@Entity
@Document(collation = "send_record")
public class VerificationCode
{
	public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

	@Id
	@Field("vid")
	private Long id;
	@Field("userKey")
	private Long userKey;
	@Field("email")
	private String email;
	@Field("mobile")
	private String mobile;
	@Field("type")
	private int type;
	@Field("code")
	private String code;
	@Field("msg")
	private String msg;
	@Field("sendTime")
	private String sendTime;
	@Field("createDate")
	private String createDate;

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
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getMobile()
	{
		return mobile;
	}
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	public int getType()
	{
		return type;
	}
	public void setType(int type)
	{
		this.type = type;
	}
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public String getMsg()
	{
		return msg;
	}
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	public String getSendTime()
	{
		return new DateTime(new Date()).toString(STANDARD_FORMAT);
	}
	public void setSendTime(String sendTime)
	{
		this.sendTime = sendTime;
	}
	public String getCreateDate()
	{
		return new DateTime(new Date()).toString(STANDARD_FORMAT);
	}
	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}
}
