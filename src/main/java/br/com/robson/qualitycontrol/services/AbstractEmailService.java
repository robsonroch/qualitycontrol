package br.com.robson.qualitycontrol.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import br.com.robson.qualitycontrol.models.Employee;
import br.com.robson.qualitycontrol.models.User;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;

	@Override
	public void sendOrderConfirmationEmail(User observer) {
		SimpleMailMessage sm = prepareSimpleMailMenssageFromPedido(observer);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMenssageFromPedido(User observer) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(observer.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Nova notificação de incidência");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Funcionario Criado");
		
		return sm;
	}

}
