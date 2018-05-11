package com.revajr.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.revajr.cursomc.services.DBService;
import com.revajr.cursomc.services.EmailService;
import com.revajr.cursomc.services.SmtpEmailService;

@Configuration
@Profile("prod")
public class ProdConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
		
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		if(!"create".equals(strategy)) {
			return false;
		}
		dbService.instantiateTestDatabase();
		return true;
	}
	
	/*
	 * Qndo rodar em DEV e PROD, vai instanciar um SmtpEmailService, e não um MockEmailService
	 */
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
