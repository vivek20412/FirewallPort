package com.ams.ulity;

import java.util.Random;

public class OtpGenerator {


    
    public static final String numbers = "0123456789"; 
    
  
    
    
	public char[] generatorotp()
	{
		
		System.out.println("Generating OTP using random() : "); 
        System.out.print("You OTP is : "); 
  
   
  
        // Using random method 
        Random rndm_method = new Random(); 
  
        char[] otp = new char[6]; 
  
        for (int i = 0; i < 6; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
        	
        	 otp[i] = 
             numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        return  otp; 
	}
	
	public static void main(String[] args) {		          
		
		 char[] alpha = new OtpGenerator().generatorotp();
         String bar = String.valueOf(alpha);
		 System.out.println(bar);
	}
}

