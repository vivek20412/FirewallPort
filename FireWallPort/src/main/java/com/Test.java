package com;

import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
       String rawPass="user";
       String encodedPass=encoder.encode(rawPass);
       System.out.println("encoded="+encodedPass);
       long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
       System.out.println("Number="+number);
       String uniqueID = UUID.randomUUID().toString();
       System.out.println("uniqueID="+uniqueID);
	}

}
