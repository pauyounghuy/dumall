package com.byh.mall.mail;
import org.springframework.mail.SimpleMailMessage;

public interface MailService
{
	void sendMail(SimpleMailMessage simpleMailMessage);
}
