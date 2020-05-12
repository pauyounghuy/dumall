package com.byh.mall.entity;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.thymeleaf.util.StringUtils;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

//游客访问/登录记录
@Document(collation = "visitor")
public class Visitor
{
	public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";

	@Id
	@Field("vid")
	private Long id;
	//访问ip
	@Field("ip")
	private String ip;
	//访问/登录  时间
	@Field("visitTime")
	private String visitTime;
	//用户名  可选
	@Field("userName")
	private String userName;
	//是否登录     0未登录   1已登录
 	@Field("isEnter")
	private int isEnter=0;
	//退出  时间  可选
	@Field("quitTime")
	private String quitTime;
 	//停留时长    --小时  可选
	@Field("duration")
	private Float duration=0f;

	public Visitor()
	{
	}
	public Visitor(String ip, String visitTime, int isEnter)
	{
		this.ip = ip;
		this.visitTime = visitTime;
		this.isEnter = isEnter;
	}
	public Visitor(String ip, String visitTime, String userName, int isEnter)
	{
		this.ip = ip;
		this.visitTime = visitTime;
		this.userName = userName;
		this.isEnter = isEnter;
	}
	public Visitor(String ip, String visitTime, String userName, int isEnter, String quitTime, Float duration)
	{
		this.ip = ip;
		this.visitTime = visitTime;
		this.userName = userName;
		this.isEnter = isEnter;
		this.quitTime = quitTime;
		this.duration = duration;
	}
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getIp()
	{
		return ip;
	}
	public void setIp(String ip)
	{
		this.ip = ip;
	}
	public String getVisitTime()
	{
		return new DateTime(new Date()).toString(STANDARD_FORMAT);
	}
	public void setVisitTime(String visitTime)
	{
		this.visitTime = visitTime;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public int getIsEnter()
	{
		return isEnter;
	}
	public void setIsEnter(int isEnter)
	{
		this.isEnter = isEnter;
	}
	public String getQuitTime()
	{
		return new DateTime(new Date()).toString(STANDARD_FORMAT);
	}
	public void setQuitTime(String quitTime)
	{
		this.quitTime = quitTime;
	}
	public Float getDuration()
	{
		float time = 0f;
		if (!StringUtils.isEmpty(visitTime) && !StringUtils.isEmpty(quitTime)){
			Date visitorT = DateTimeFormat.forPattern(STANDARD_FORMAT).parseDateTime(visitTime).toDate();
			Date quitT = DateTimeFormat.forPattern(STANDARD_FORMAT).parseDateTime(quitTime).toDate();
			BigDecimal bdv=new BigDecimal(visitorT.getTime());  //登录毫秒
			BigDecimal bdq=new BigDecimal(quitT.getTime());  //退出毫秒
			time=bdq.subtract(bdv).divide(new BigDecimal(36*1000*1000), 3, BigDecimal.ROUND_HALF_UP).floatValue();
		}

		return time;
	}
	public void setDuration(Float duration)
	{
		this.duration = duration;
	}

}
