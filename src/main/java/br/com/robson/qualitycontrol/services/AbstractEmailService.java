package br.com.robson.qualitycontrol.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import br.com.robson.qualitycontrol.models.Employee;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("${default.sender}")
	private String sender;

	@Override
	public void sendOrderConfirmationEmail(Employee employee) {
		SimpleMailMessage sm = prepareSimpleMailMenssageFromPedido(employee);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMenssageFromPedido(Employee employee) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(employee.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Nova notificação de incidência");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Funcionario Criado");
		
		return sm;
	}

}
