package com.byh.mall.entity;

import java.io.Serializable;

public class SendMessage implements Serializable
{
	//发件人
	private String from;
	//收件人
	private String to;
	//抄送人
	private String cc;
	//密送人
	private String bcc;
	//主题
	private String title;
	//内容
	private String content;

	public SendMessage()
	{
	}
	public SendMessage(String from, String to, String cc, String bcc)
	{
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
	}
	public SendMessage(String title, String content)
	{
		this.title = title;
		this.content = content;
	}
	public SendMessage(String from, String to, String cc, String bcc, String title, String content)
	{
		this.from = from;
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.title = title;
		this.content = content;
	}
	public String getFrom()
	{
		return from;
	}
	public void setFrom(String from)
	{
		this.from = from;
	}
	public String getTo()
	{
		return to;
	}
	public void setTo(String to)
	{
		this.to = to;
	}
	public String getCc()
	{
		return cc;
	}
	public void setCc(String cc)
	{
		this.cc = cc;
	}
	public String getBcc()
	{
		return bcc;
	}
	public void setBcc(String bcc)
	{
		this.bcc = bcc;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
}
