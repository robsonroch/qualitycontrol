package br.com.robson.qualitycontrol.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.robson.qualitycontrol.models.Employee;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Employee employee);
	
	void sendEmail(SimpleMailMessage msg);

}
