package com.byh.mall.entity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AliYun
{
	@Value("${accessKeyId}")
	private String accessKey;
	@Value("${accessKeySecret}")
	private String secretKey;
	@Value("${groupId}")
	private String groupId;
	@Value("${msgTopic}")
	private String topicMsg;
	@Value("${namesrv}")
	private String nameSrv;
	@Value("${namehttp}")
	private String nameHttp;
	@Value("${signName}")
	private String signName;
	@Value("${templateCode}")
	private String tempCode;
	@Value("${regionId}")
	private String regionId;

	public String getAccessKey()
	{
		return accessKey;
	}
	public void setAccessKey(String accessKey)
	{
		this.accessKey = accessKey;
	}
	public String getSecretKey()
	{
		return secretKey;
	}
	public void setSecretKey(String secretKey)
	{
		this.secretKey = secretKey;
	}
	public String getGroupId()
	{
		return groupId;
	}
	public void setGroupId(String groupId)
	{
		this.groupId = groupId;
	}
	public String getTopicMsg()
	{
		return topicMsg;
	}
	public void setTopicMsg(String topicMsg)
	{
		this.topicMsg = topicMsg;
	}
	public String getNameSrv()
	{
		return nameSrv;
	}
	public void setNameSrv(String nameSrv)
	{
		this.nameSrv = nameSrv;
	}
	public String getNameHttp()
	{
		return nameHttp;
	}
	public void setNameHttp(String nameHttp)
	{
		this.nameHttp = nameHttp;
	}
	public String getSignName()
	{
		return signName;
	}
	public void setSignName(String signName)
	{
		this.signName = signName;
	}
	public String getTempCode()
	{
		return tempCode;
	}
	public void setTempCode(String tempCode)
	{
		this.tempCode = tempCode;
	}
	public String getRegionId()
	{
		return regionId;
	}
	public void setRegionId(String regionId)
	{
		this.regionId = regionId;
	}
}


//https://blog.csdn.net/qq_37164847/article/details/81389269
//https://blog.csdn.net/alan_liuyue/article/details/86645887
//https://www.jianshu.com/p/dc93d97bc3c1
//https://msd.misuland.com/pd/2884250034537239574
//https://www.cnblogs.com/JohnDawson/p/11613637.html
//https://blog.csdn.net/li521wang/article/details/89460692
//https://www.jianshu.com/p/448927b6172d
//https://help.aliyun.com/document_detail/29553.html?spm=a2c4g.11186623.2.24.547f9da3iVnkWT#multiTask8532