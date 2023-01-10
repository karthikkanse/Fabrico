package com.ty.fabrico.fabrico_springboot.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ty.fabrico.fabrico_springboot.dao.CartDao;
import com.ty.fabrico.fabrico_springboot.dto.Cart;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private CartDao dao;
	
	public void sendEmail(String toEmail,String subject,String cartId) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("fabricoapplication@gmail.com");
		message.setTo(toEmail);
		message.setSubject(subject);
		Optional<Cart> cart2=dao.getCartById(cartId);
		if(cart2.isPresent())
		{
			Cart cart=cart2.get();
			message.setText(cart.getCartName()+" "+cart.getTotalcost());
			mailSender.send(message);
			System.out.println("Mail Sent Successfully");
		}
	}
}
