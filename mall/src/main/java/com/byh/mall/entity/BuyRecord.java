package com.byh.mall.entity;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Entity;

//购买记录
@Entity
@Document(collation = "buy_record")
public class BuyRecord
{
	public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";




}
