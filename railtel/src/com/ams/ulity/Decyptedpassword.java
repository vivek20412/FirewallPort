package com.ams.ulity;




import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Decyptedpassword {
	
	
	public String get_SHA_512_SecurePassword(String passwordToHash, String   salt){
	
	String generatedPassword = null;
    try {
         MessageDigest md = MessageDigest.getInstance("SHA-512");
         md.update(salt.getBytes(StandardCharsets.UTF_8));
         byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
         StringBuilder sb = new StringBuilder();
         for(int i=0; i< bytes.length ;i++){
         sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
         }
         generatedPassword = sb.toString();
        } 
       catch (NoSuchAlgorithmException e){
        e.printStackTrace();
       }
    return generatedPassword;
}
	
	public static void main(String[] args) {
		
		String password = new Decyptedpassword().get_SHA_512_SecurePassword("vivek", "10");
		System.out.println(password);
	}

}
