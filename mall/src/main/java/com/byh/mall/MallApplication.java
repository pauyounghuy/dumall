package com.byh.mall;
import com.byh.mall.nettyecho.NettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
@MapperScan("com.byh.mall.dao.*")
@EnableTransactionManagement
@EnableCaching
@EnableWebSocket
public class MallApplication implements ServletContextInitializer
{
	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(MallApplication.class, args);
		//开启netty服务
		new NettyServer(12345).start();
	}
	//设置websocket发送内容长度
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException
	{
		servletContext.setInitParameter("org.apache.tomcat.websocket.textBufferSize","10240000");
	}
}
