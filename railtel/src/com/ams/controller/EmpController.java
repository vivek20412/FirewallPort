package com.ams.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.ietf.ldap.LDAPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import com.ams.Doa.Doa;
import com.ams.Doa.Smsgatewayapi;
import com.ams.bean.Employee;
import com.ams.bean.Otp_status;
import com.ams.bean.Paswordchange;
import com.ams.bean.SmsLogs;
import com.ams.date.ServerDateTime;
import com.ams.ulity.Ldapconnection;
import com.ams.ulity.OtpGenerator;

@Controller
public class EmpController {

	String email = null;
	String phoneno = null;
	String otpuser = null;
	String useremail = null;
	int valueslimit=0;
	String expritime=null;
	String generatetime=null;
	HashMap<String,Integer> limitotp=null;

	int  ipaddress=0;
	 int iplimit =0;

	@Autowired
	Doa DoaId;
	
	@Autowired
	SmsLogs sms;

	@Autowired
	Employee employeeId;

	@Autowired
	Paswordchange paswordchangeId;

	@Autowired
	Otp_status OtpId;

	public EmpController() {
	}

	@RequestMapping({ "change_password" })
	public String showHomePage(ModelMap map) throws UnsupportedEncodingException, LDAPException {

		map.put("employeeId", employeeId);

		return "admin_home";
	}

	@RequestMapping({ "sendotp" })
	public ModelAndView send_OtpCustomer(HttpServletRequest request, ModelMap map,
			@ModelAttribute("employeeId") Employee employeeId)
			throws UnsupportedEncodingException, LDAPException, ParseException {

		/* email = HtmlUtils.htmlEscape(employeeId.getEmailid()); */
		
		 email = HtmlUtils.htmlEscape(employeeId.getEmailid());
		  
System.out.println(email);
		  
		  if(email==null)
		  {
			    map.put("employeeId", employeeId);
			    map.put("status", "*invalid emailid");
				return new ModelAndView("admin_home", map);
			  
		  }
		
		System.out.println(email);
		if (email.contains("&")) {
			 map.put("employeeId", employeeId);
			map.put("status", "*invalid emailid");
			return new ModelAndView("admin_home", map);
		}

		phoneno = DoaId.checkMailId(email);
		
		System.out.println("phonoe"+phoneno);
		
		if(phoneno==null)
		{
			map.put("employeeId", employeeId);
			map.put("status", "*invalid emailid");
			return new ModelAndView("admin_home", map);
		}
		

		String ipaddress = request.getRemoteAddr();
		if (ipaddress == null) {
			ipaddress = "Notfound";
		}

		System.out.println("ipaddress" + ipaddress);



		if (email != null) {

			if (phoneno != null) {
				char[] otp = new OtpGenerator().generatorotp();
				String userotp = String.valueOf(otp);
				otpuser=userotp;
				Date generate = new ServerDateTime().currenttime();
				Date expriti = new ServerDateTime().expritime();

				SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
				generatetime = dateFormat.format(generate);
			     expritime = dateFormat.format(expriti);

				System.out.println("phoneno" + phoneno);
				
				List<Otp_status> otplist = DoaId.limitstatus(email);
				
				
				List<String>iplist=new ArrayList<String>();
				 Set<String> uniqueSet = new HashSet<String>();
				 List<String> dupesList = new ArrayList<String>();
				       List<Otp_status> userlistip = DoaId.checkiplist();
				       
				       Iterator itp = userlistip.iterator();
				       
				   	while(itp.hasNext())
					{
				   	 Otp_status otpstatus = (Otp_status)itp.next();
				   	 
				     iplist.add(otpstatus.getIpaddress());
					}
				        
				
				DoaId.limitstatus(email);
			
			    limitotp= new HashMap<String,Integer>();
				Iterator it = otplist.iterator();
				while(it.hasNext())
				{
			                     Otp_status otpstatus = (Otp_status)it.next();
				                           
					             String otptimes = otpstatus.getOtp();
					          
					             
				                 int times = otpstatus.getTimes();
				                 limitotp.put(otptimes,times);
				                 
				                   
				                  
					 
				}
				 
				
				for (String ipaddres : iplist) {
		            if (uniqueSet.contains(ipaddres))
		                dupesList.add(ipaddres);
		            else
		                uniqueSet.add(ipaddres);
		        }
		        System.out.println(uniqueSet.size() + " distinct ipadrees " + uniqueSet);
		        System.out.println(dupesList.size() + " dupesList uniquie " + dupesList);
				
				
				
				
			
				System.out.println(otplist);
				
				

			   valueslimit=limitotp.size();
			   System.out.println("limit"+valueslimit);
			           iplimit    =dupesList.size();
			               
			       
			}
			

			} 
			
				if(valueslimit<=2)
				{
					int status = 1;
					String value = "false";
					
					DoaId.saveotp(email,expritime, otpuser, phoneno, generatetime, status,value,ipaddress); 
					
	                 
					System.out.println("readotp" +otpuser);
				
					
			       new Smsgatewayapi().sendmessage(otpuser, phoneno); 
				           
					map.put("email",email);
					map.put("phoneno", "otp has been sent to******" + phoneno.substring(8, 10));
					map.put("Otpid", OtpId);
					
					
					return new ModelAndView("send_otp", map);	
					 
				
				}
				
				else
				{
                   
					 map.put("status", "*exceed maximum limit");
						
						return new ModelAndView("admin_home", map);
			
		
		

		}
		
	}



	@RequestMapping({ "confirm_otp" })
	public ModelAndView Cross_site_Scripting(HttpServletRequest request, ModelMap map,
			@ModelAttribute("Otpid") Otp_status Otpid)
			throws UnsupportedEncodingException, LDAPException, ParseException {

		String confirmotp = HtmlUtils.htmlEscape(Otpid.getOtp());
		System.out.println(confirmotp);
		
		   int valueslimit=limitotp.size();
		  
		   System.out.println("limit"+valueslimit);
		
			if(valueslimit>2)
			{
				map.put("status", "*exceed maximum limit");
				
				map.put("employeeId", employeeId);

				
				return new ModelAndView("admin_home", map);
				
				
			}

		if (confirmotp.contains("&")) {
			map.put("email", email);
			map.put("status", "*invalid OTP");
			return
					new ModelAndView("send_otp", map);
		}
		Integer maxid = DoaId.getMaxidEmail(email, confirmotp);
		String exprtime = DoaId.getExpiretime(maxid, confirmotp);
		String generattime = DoaId.getGeneratetime(maxid);
		System.out.println("exprtime" + exprtime);
		System.out.println("generatetime" + generattime);
		System.out.println(exprtime);

		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

		if (generattime != null && exprtime != null) {

			if (dateFormat.parse(generattime).after(dateFormat.parse(exprtime))) {

				map.put("email", email);
				map.put("status", "*invalid OTP");
				return new ModelAndView("send_otp", map);

			} else {
				if (confirmotp.equalsIgnoreCase(otpuser)) {
					map.put("paswordchangeId", paswordchangeId);
					map.put("email", email);
					return new ModelAndView("changepassword", map);

				}

			}
		}
		map.put("paswordchangeId", paswordchangeId);
		map.put("email", email);
		map.put("status", "*invalid OTP");
		return new ModelAndView("send_otp", map);

	}

	@RequestMapping({ "passchange" })
	public ModelAndView ldapasswordchange(HttpServletRequest request, ModelMap map,
			@ModelAttribute("paswordchangeId") Paswordchange paswordchangeId)
			throws UnsupportedEncodingException, LDAPException {

		String emasil = null;
		String mailid = email;
		
		String password = request.getParameter("password");
		System.out.println(paswordchangeId.getConfirmpassword());
		String confirmpassword = HtmlUtils.htmlEscape(paswordchangeId.getConfirmpassword());

		System.out.println(mailid);

		if (confirmpassword.equals(password)) {
			System.out.println("useremail" + email);

			System.out.println("password" + password);
			String servertime = new ServerDateTime().serverTime();
			DoaId.Ldappasswordchange(email, servertime);
			new Ldapconnection().changeLdapaccountpassword(email, password);
			return new ModelAndView("success");
		} else {
			map.put("email", mailid);
			map.put("status", "password does not match");
			map.put("paswordchangeId", paswordchangeId);
			return new ModelAndView("changepassword");
		}

	}

}
