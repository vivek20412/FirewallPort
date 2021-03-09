package com.ams.ulity;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mailtutil {
	
	
    public void send( String msg){
    	
    	
        //Get properties object    
        Properties props = new Properties();    
        props.put("mail.smtp.host", "mail.railtelindia.com");    
	    props.put("mail.smtp.socketFactory.port","587");  
	    props.put("mail.smtp.starttls.enable", "true");  
	    
	    props.put("mail.smtp.auth","true");
		/* props.put("mail.smtp.ssl.enable",true); */
	    props.put("mail.smtp.debug", "true");
	    props.put("mail.transport.protocol", "smtp");
	  
		
		
		
		/*
		 * props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		 */
		 
		/* props.put("mail.smtp.socketFactory.fallback", "true"); */
        props.put("mail.smtp.port","587");
     
        
        //get Session
        
        Session session = Session.getDefaultInstance(props,    
         new javax.mail.Authenticator() {    
         protected PasswordAuthentication getPasswordAuthentication() {    
         return new PasswordAuthentication("vivek-dcsupport@railtelindia.com","Vailtel@123");  
         }    
        });
        System.out.println(session.getProperties());
      
       
  
        
        try {    
         MimeMessage message = new MimeMessage(session);    
         message.addRecipient(Message.RecipientType.TO,new InternetAddress("vivek-dcsupport@railtelindia.com"));
         message.setSubject("Test sms api");    
         message.setText("Hello");
         Transport.send(message);
 
         System.out.println("message sent successfully");  
       
         
         
        }
		/*
		 * catch (SendFailedException e) {
		 * 
		 * Address[] validSentAddresses1 =e.getInvalidAddresses();
		 * System.out.println(validSentAddresses1[0].toString()); Address[]
		 * validSentAddresses2 =e.getValidSentAddresses();
		 * System.out.println(validSentAddresses2[0].toString());
		 * 
		 * 
		 * // TODO: handle exception }
		 */

        catch (MessagingException e) {
        	
        	
        	throw new RuntimeException(e);
        	
        }    
           
  }  
    public static void main(String[] args) {	
    	
    new Mailtutil().send("hello");
    
	}
}  
   



