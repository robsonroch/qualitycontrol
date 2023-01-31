package br.com.robson.qualitycontrol.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.Observer;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Observer observer);
	
	void sendEmail(SimpleMailMessage msg);

}
