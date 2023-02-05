package br.com.robson.qualitycontrol.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.robson.qualitycontrol.models.User;


public interface EmailService {
	
	void sendOrderConfirmationEmail(User observer);
		
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(User user, String newPass);

}
