package com.byh.mall.base;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class BaseEntity extends CommonBase implements Serializable
{
	//创建日期
	@Column(name="CREATE_DATE")
	@JsonProperty("createDate")
	@Field("createDate")
	private String createDate;

	//最后修改日期
	@Column(name="UPDATE_DATE")
	@JsonProperty("updateDate")
	@Field("updateDate")
	private String updateDate;

	public String getCreateDate()
	{
		return new DateTime(new Date()).toString(STANDARD_DATE);
	}
	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}
	public String getUpdateDate()
	{
		return new DateTime(new Date()).toString(STANDARD_DATE);
	}
	public void setUpdateDate(String updateDate)
	{
		this.updateDate = updateDate;
	}
}
