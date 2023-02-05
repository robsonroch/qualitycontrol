package br.com.robson.qualitycontrol.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.robson.qualitycontrol.models.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MockEmailService extends AbstractEmailService {

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		log.info("Simulando envio de email...");
		log.info(msg.toString());
		log.info("Email enviado");
	}

	@Override
	public void sendNewPasswordEmail(User user, String newPass) {
		// TODO Auto-generated method stub
		
	}

}
