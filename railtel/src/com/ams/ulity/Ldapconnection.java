package com.ams.ulity;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.ietf.ldap.LDAPAttribute;
import org.ietf.ldap.LDAPConnection;
import org.ietf.ldap.LDAPException;
import org.ietf.ldap.LDAPModification;

public class Ldapconnection {

	
	
	private static final String host="ldapserver.rcil.gov.in";
	/* private static final String host="192.168.23.34"; */ 

	/* private static final String host = "172.27.3.147"; */

	private static final int port = 389;
	
	 private static final String userdn = "uid=zimbra,cn=admins,cn=zimbra";
	 private static final String password = "VrA5adjU";
	 

	
	/*
	 * private static final String userdn="uid=zimbra,cn=admins,cn=zimbra"; private
	 * static final String password="J5UqaD74Qo";
	 */
	 

	public void changeLdapaccountpassword(String emailid, String changepassword) throws UnsupportedEncodingException, LDAPException 
	{

		String path=null;
		
		List<String> schemadetails = new ArrayList<String>();

		LDAPConnection userConn = new LDAPConnection();
		System.out.println(userConn.getProtocolVersion());
		userConn.connect(host, port);
		userConn.bind(3, userdn, password.getBytes("UTF8"));
		
		if(emailid.endsWith("@mrvc.gov.in"))
		{
	    String modifyemail = emailid.replace("@mrvc.gov.in", " ").trim();
	    path= "uid=" + modifyemail + ",ou=people,dc=mrvc,dc=gov,dc=in";
	 
		}
		
		if(emailid.endsWith("@railtelindia.com"))
		{
	    String modifyemail = emailid.replace("@railtelindia.com", " ").trim();
	    path= "uid=" + modifyemail + ",ou=people,dc=railtelindia,dc=com";
	 
		}
		

		
		if(emailid.endsWith("@relindia.in"))
		{
	    String modifyemail = emailid.replace("@relindia.in", " ").trim();
	    path= "uid=" + modifyemail + ",ou=people,dc=relindia,dc=in";
	 
		}
		System.out.println(path);

		
		
		LDAPAttribute attr = new LDAPAttribute("userPassword", changepassword);
		LDAPModification mod = new LDAPModification(LDAPModification.REPLACE, attr);

		try {
			userConn.modify(path, mod);
		} catch (LDAPException e) {
			throw e;
		}



		System.out.println(userConn.getAuthenticationDN() + "Authenication");

	}

}
