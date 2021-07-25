package br.com.robson.qualitycontrol.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.Notice;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Employee employee);
	
	void sendEmail(SimpleMailMessage msg);

}
