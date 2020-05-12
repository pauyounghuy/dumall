package com.byh.mall;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.byh.mall.dao.*")
@EnableTransactionManagement
@EnableCaching
public class MallApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(MallApplication.class, args);
	}
}
