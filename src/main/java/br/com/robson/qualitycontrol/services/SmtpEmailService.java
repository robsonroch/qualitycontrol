package br.com.robson.qualitycontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import br.com.robson.qualitycontrol.models.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmtpEmailService extends AbstractEmailService{
	
	@Autowired
	private MailSender mailSender;

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		log.info("Enviando de email...");
		mailSender.send(msg);
		log.info("Email enviado");
		
	}

	@Override
	public void sendNewPasswordEmail(User user, String newPass) {
		// TODO Auto-generated method stub
		
	}

}
