package com.revajr.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.revajr.cursomc.dominio.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	
}
