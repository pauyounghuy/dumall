package com.byh.mall.base;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseDAO extends CommonBase
{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;


}
