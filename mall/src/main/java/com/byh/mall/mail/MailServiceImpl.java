package com.byh.mall.mail;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.byh.mall.base.BaseService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl extends BaseService implements MailService
{
	@Autowired
	private JavaMailSender mailSender;

	public void sendMail(SimpleMailMessage simpleMailMessage)
	{
			//读取配置文件中的收件人    ---如果是多个收件人
			//String[] to = mailTo.split(",");  // 收件人
			MimeMessage mailMessage = mailSender.createMimeMessage();
			System.out.println("发送邮件给： "+simpleMailMessage.getTo());
			try
			{
				MimeMessageHelper helper = new MimeMessageHelper(mailMessage,true,"utf-8");
				helper.setFrom(simpleMailMessage.getFrom());
				helper.setTo(simpleMailMessage.getTo());
				helper.setSubject(simpleMailMessage.getSubject());
				
				if (ArrayUtils.isNotEmpty(simpleMailMessage.getCc()))
				{
					helper.setCc(simpleMailMessage.getCc()); //抄送人
				}
				if (ArrayUtils.isNotEmpty(simpleMailMessage.getBcc()))
				{
					helper.setCc(simpleMailMessage.getBcc()); //密送人
				}
				
				helper.setText(simpleMailMessage.getText());
				mailSender.send(mailMessage);
				System.out.println("邮件发送成功.....");
			}
			catch (Exception e)
			{
				System.out.println("邮件发送发生异常");
				System.out.println(e.getMessage());
			}

	}
	
}
