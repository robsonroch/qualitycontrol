package br.com.robson.qualitycontrol.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.robson.qualitycontrol.services.DBService;
import br.com.robson.qualitycontrol.services.EmailService;
import br.com.robson.qualitycontrol.services.SmtpEmailService;

@Configuration
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException{
		dbService.instantiateTestDatabase();
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
