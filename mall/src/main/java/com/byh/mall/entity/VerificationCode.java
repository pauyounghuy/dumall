package com.byh.mall.entity;

import com.byh.mall.base.BaseEntity;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

//发送记录
@Entity
@Table(name="app_verification_code")
@Document(collation = "send_record")
public class VerificationCode
{
	public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

	@Id
	@Column(name="ID")
	@Field("vid")
	private Long id;
	@Column(name="USER_KEY")
	@Field("userKey")
	private Long userKey;
	@Column(name="EMAIL")
	@Field("email")
	private String email;
	@Column(name="MOBILE")
	@Field("mobile")
	private String mobile;
	@Column(name="TYPE")
	@Field("type")
	private int type;
	@Column(name="CODE")
	@Field("code")
	private String code;
	@Column(name="TITLE")
	@Field("title")
	private String title;
	@Column(name="MSG")
	@Field("msg")
	private String msg;
	@Column(name="SEND_TIME")
	@Field("sendTime")
	private String sendTime;
	@Column(name="CREATE_DATE")
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
