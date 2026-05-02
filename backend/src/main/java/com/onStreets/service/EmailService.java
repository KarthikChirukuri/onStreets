package com.onStreets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public void sendLeadEmail(String to, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setText(content);
		message.setSubject("New lead received!");
		
		mailSender.send(message);
	}
	
}
