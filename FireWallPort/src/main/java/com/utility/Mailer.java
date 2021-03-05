package com.utility;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

public class Mailer{  
	 public  void send(String from,String password,String to,String sub,String msg){  
        
  	 Properties props = new Properties();    
       props.put("mail.smtp.host", "mail.railtelindia.com");    
	    props.put("mail.smtp.socketFactory.port","587");  
	   //props.put("mail.smtp.starttls.enable", "true");  
	    
	    props.put("mail.smtp.auth","true");
		//props.put("mail.smtp.ssl.enable",true); 
	    props.put("mail.smtp.debug", "true");
	    props.put("mail.transport.protocol", "smtp");
	  
		
		
		
		
		//  props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		 
		 
		// props.put("mail.smtp.socketFactory.fallback", "true"); 
       props.put("mail.smtp.port","587");
    
    
  	
  	
  	
        //get Session   
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication(from,password);  
         }    
        });    
        //compose message    
        try {    
         MimeMessage message = new MimeMessage(session); 
         message.setFrom(new InternetAddress(from));  
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
         message.setSubject(sub);    
        // message.setText(msg);    
        message.setContent(msg,"text/html" );  
         //send message  
         Transport.send(message);    
         System.out.println("message sent successfully");    
        } catch (MessagingException e) {throw new RuntimeException(e);}    
           
  }  
}  
