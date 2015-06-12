package com.carmanager.utils;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.carmanager.entities.User;

public class SenderMailUtils {

	@Autowired
	private JavaMailSenderImpl mailSender;
	@Autowired
	private VelocityEngine velocityEngine;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void sendMail(User user) {
		// 通过MailSender创建一个邮件
		MimeMessage message = mailSender.createMimeMessage();
		try {
			// 这里的MimeMessageHelper是用来封装邮件的一些基本信息
			MimeMessageHelper helper = new MimeMessageHelper(message, true,
					"UTF-8");
			helper.setFrom("yqr271228943@qq.com");// 发件人的地址
			helper.setTo(user.getEmail());// 收件人的地址
			helper.setSubject("CarManager服务平台");// 邮件的主题
			MimeBodyPart body = new MimeBodyPart();// 邮件体
			Map model = new HashMap();
			model.put("regTime", DateUtils.dateToString(user.getCreateTime()));
			model.put("user", user);
			String text = VelocityEngineUtils.mergeTemplateIntoString(
					velocityEngine, "registration-confirmation.vm", "UTF-8",
					model);
			body.setContent(text, "text/html;charset=UTF-8");
			MimeMultipart mp = new MimeMultipart();
			mp.addBodyPart(body);
			message.setContent(mp);
			mailSender.send(message);// 发送邮件
			System.out.println("发送成功");
		} catch (MessagingException e) {
			System.out.println("发送失败");
			e.printStackTrace();
		} catch (MailException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}