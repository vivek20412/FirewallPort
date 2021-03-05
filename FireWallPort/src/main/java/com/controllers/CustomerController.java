package com.controllers;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Customer;
import com.bean.CustomerDetails;
import com.bean.IPList;
import com.bean.ServerDetails;
import com.bean.ServerDetailsTicket;
import com.bean.User;
import com.dao.CustomerDetailsRepository;
import com.dao.DcTeamRepository;
import com.dao.UserRepository;
import com.utility.Mailer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerDetailsRepository customerDetailsRepository;
	@Autowired UserRepository userRepository;
	@Autowired DcTeamRepository dcRepository;
	Mailer mailer;
	@GetMapping("/addCustomerDetails")
	public String addCustomerDetails(Model model,Principal principal,HttpSession session)
	{
		CustomerDetails  customerDetails=new CustomerDetails(); 
		model.addAttribute("customerDetails", customerDetails);
		User user = userRepository.getUserByUsername(principal.getName());
		session.setAttribute("name", user.getName());
		model.addAttribute("name", user.getName());
		model.addAttribute("user", user);
		return "customer";
		
	}
	@PostMapping("/saveCustomerDetails")
	public ModelAndView saveCustomerDetails( @ModelAttribute("customerDetails") @Valid CustomerDetails customerDetails,BindingResult br,Principal principal,HttpServletRequest request)
	{
		
		//request.getp
		ModelAndView model=null;
		
		String page="";
		String msg=null;
		if(br.hasErrors())
		{
			System.out.println("inside haserror");
			page="customer";
		}
		else
		{
			String[] sourceip = request.getParameterValues("sourceip");
			String[] sorceport = request.getParameterValues("sorceport");
			String[] destinationip = request.getParameterValues("destinationip");
			String[] destinationport = request.getParameterValues("destinationport");
			List<IPList> list=new ArrayList<>();
			for(int i=0;i<sourceip.length;i++)
			{
				IPList iplist=new IPList();
				//iplist.setSource_ip(sourceip[i]);
				//iplist.setSource_port(sorceport[i]);
				//iplist.setDestination_ip(destinationip[i]);
				//iplist.setDestination_port(destinationport[i]);
				list.add(iplist);
				
				
			}
			long service_no = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		String message="<h1>"+customerDetails.getCustomername()+"</h1> <h3>wants to open port. Details are give below</h3><br><br>"
				+ "Source Ip Address--"+"</br>"
						+ "Destination Ip Address--"+"</br>"
								+ "Source Port--"+"</br>"
										+ "Destination Port--"+"</br>";
		String username=principal.getName();
		System.out.println("username before saving="+username);
		System.out.println("save customer called");
		System.out.println("Name="+customerDetails.getCustomername());
		customerDetails.setUsername_cust_details(username);
		customerDetails.setService_no("SR"+String.valueOf(service_no));
		customerDetails.setIplist(list);
		customerDetailsRepository.save(customerDetails);
		mailer=new Mailer();
		//mailer.send("vivek-dcsupport@railtelindia.com", "Railtel@123", "avanish-socsupport@railtelindia.com", "Test", message);
		page="CustomerDetailsSuccess";
		msg="Details Saved Successfully!!!!";
		model=new ModelAndView();
		model.addObject("data", customerDetails);
		}
		//model.addAttribute("msg", "Details Saved Successfully!!!!");
		 System.out.println("page="+page);
		model.setViewName(page);
		
		//model.addObject("msg",msg);
		return model;
	}
	{
		
	}
	/*
	 * @GetMapping("") public ModelAndView customerHome() { ModelAndView model=new
	 * ModelAndView(); model.setViewName("customer"); return model; }
	 */
   @GetMapping("/viewOldRequests") 
   public ModelAndView viewOldRequests(Principal principal,Model mod)
   {
	   String username=principal.getName();
	   //List<CustomerDetails> id=customerDetailsRepository.getDetailsByUsername(username);
 ModelAndView model=new ModelAndView();
	   
	   model.addObject("user", username);
	   
	  
	   //System.out.println("id"+id);
	   List<CustomerDetails> oldRequestsList = customerDetailsRepository.getDetailsByUsername(username);
	   model.addObject("oldRequestsList", oldRequestsList);
	   
		
		  for(CustomerDetails cust:oldRequestsList) { List<IPList> list =
		  cust.getIplist(); for(IPList l:list) {
		   } }
		 
	 
	   model.setViewName("oldRequestsList");
	   return model;
   }
   
   @GetMapping("changeRequest/{service_no}")
   public ModelAndView changeRequest(@PathVariable String service_no)
   {
	CustomerDetails customerdetails = customerDetailsRepository.getDetailsByServiceno(service_no);
	System.out.println("==========================================================================================================");
	System.out.println(customerdetails.getService_no());
	
	List<IPList> list = customerdetails.getIplist();
	for(IPList iplist:list)
	{
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//System.out.println(iplist.getSource_ip());
	}
	
	ModelAndView model=new ModelAndView();
	model.addObject("customerDetailsUpdate", new CustomerDetails());
	model.addObject("customerdetails", customerdetails);
	model.setViewName("changeRequest");
	   return model;
	   
   }
   @PostMapping("/updateCustomerDetails")
   public ModelAndView updateCustomerDetails(@ModelAttribute("customerDetails") @Valid CustomerDetails customerDetails,BindingResult br,Principal principal,HttpServletRequest request)
   {
	   
	   String[] sourceip = request.getParameterValues("sourceip");
		String[] sorceport = request.getParameterValues("sorceport");
		String[] destinationip = request.getParameterValues("destinationip");
		String[] destinationport = request.getParameterValues("destinationport");
		List<IPList> list=new ArrayList<>();
		for(int i=0;i<sourceip.length;i++)
		{
			IPList iplist=new IPList();
			//iplist.setSource_ip(sourceip[i]);
			//iplist.setSource_port(sorceport[i]);
			//iplist.setDestination_ip(destinationip[i]);
			//iplist.setDestination_port(destinationport[i]);
			list.add(iplist);
			
			
		}
		customerDetails.setIplist(list);
	   customerDetailsRepository.save(customerDetails);
	   ModelAndView model=new ModelAndView();
	   model.addObject("msg", "Change Request Submitted Successfully!!!!");
	   model.setViewName("changeRequest");
	return model;
	   
   }
   
   
   @GetMapping("/viewVms")
   public ModelAndView viewVms(Principal principal)
   {
	   String username = principal.getName();
	   List<Customer> vmsDetails = dcRepository.getCustomerDetailsByUserName(username);
	   List<CustomerDetails> tickets = customerDetailsRepository.getDetailsByUsername(username);
	   for(Customer cust:vmsDetails)
	   {
		   System.out.println("?????????????????????????????????????????????????????");
		   System.out.println(cust.getCustomername());
		 
	   }
	   for(CustomerDetails customer1:tickets)
	   {
		   System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		   System.out.println(customer1.getTicketStatus());
	   }
	   ModelAndView model=new ModelAndView();
	   model.addObject("vmsDetails",vmsDetails);
	   model.addObject("tickets", tickets);
	   model.setViewName("viewVms");
	return model;
   }
   
   
   
   @GetMapping("/raiseRequest/{id}")
   public ModelAndView raiseRequest(@PathVariable("id") int id,Principal principal)
   {  
       String username = principal.getName();
	   System.out.println("iddddddddddddddddddddddd============"+id);
	     ServerDetails cust = null;
	    User user = userRepository.getUserByUsername(username);
	  // List<CustomerDetails> tickets = customerDetailsRepository.getDetailsByUsername(username);
	   //for(CustomerDetails ticket:tickets)
	  // {System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		//   System.out.println(ticket.getCustomername());
	   //} 
	    ServerDetails server = dcRepository.getServerDetailsSingleRow(id);
	    System.out.println("Dfdfdf====="+server.getHostname());
	   ModelAndView model=new ModelAndView();
	   model.addObject("server", server);
	   model.addObject("customerDetails", new CustomerDetails());
	   model.addObject("cust",cust);
	   model.addObject("user", user);
	   model.setViewName("raiseRequest");
	   
	return model;
	   
   }
   @PostMapping("/doRequest")
   public ModelAndView doRequest(@ModelAttribute("customerDetails") @Valid CustomerDetails customerDetails,BindingResult br,Principal principal,HttpServletRequest request)
   {
	    String[] activationtime = request.getParameterValues("activationtime");
		String[] deactivationTime = request.getParameterValues("deactivationtime");
		System.out.println("deactivationTime===="+deactivationTime);
		String[] sourceIp = request.getParameterValues("sourceIp");
		String[] ipentry = request.getParameterValues("ipentry");
		String[] direction = request.getParameterValues("direction");
		String[] port = request.getParameterValues("port");
		String[] action = request.getParameterValues("action");
		String[] comments = request.getParameterValues("comments");
		String hostname = request.getParameter("hostname");
		String os = request.getParameter("os");
		String privateip = request.getParameter("privateip");
		String publicip = request.getParameter("publicip");
		String nat = request.getParameter("nat");
		long num1 = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		long num2 = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		long service_no=num1+num2;
		List<IPList> list=new ArrayList<>();
		for(int i=0;i<activationtime.length;i++)
		{
			IPList iplist=new IPList();
			iplist.setActivationTime(activationtime[i]);
			iplist.setDeactivationTime(deactivationTime[i]);
			iplist.setSourceIp(sourceIp[i]);
			iplist.setIpentry(ipentry[i]);
			iplist.setDirection(direction[i]);
			iplist.setPort(port[i]);
			iplist.setAction(action[i]);
			iplist.setComments(comments[i]);
		
			list.add(iplist);
			
			
		}
		List<ServerDetailsTicket> server=new ArrayList<>();
		ServerDetailsTicket ticket=new ServerDetailsTicket();
		ticket.setHostname(hostname);
		ticket.setOs(os);
		ticket.setPrivateip(privateip);
		ticket.setPublicip(publicip);
		ticket.setNat(nat);
		server.add(ticket);
		customerDetails.setServerDetailsForTicket(server);
		customerDetails.setIplist(list);
		customerDetails.setService_no(String.valueOf("SR"+service_no));
	   customerDetails.setUsername_cust_details(principal.getName());
	   customerDetails.setTicketStatus("pending");
	   
	   customerDetailsRepository.save(customerDetails);
	   ModelAndView model=new ModelAndView();
	   model.addObject("data",customerDetails );
	   model.setViewName("CustomerDetailsSuccess");
	return model;
	   
   }
   @GetMapping("/showServiceDetails/{service_no}")
   public ModelAndView showServiceDetails(@PathVariable("service_no") String service_no)
   {
	   CustomerDetails serviceDetails = customerDetailsRepository.getDetailsByServiceno(service_no);
	   
	   ModelAndView model=new ModelAndView();
	   model.addObject("serviceDetails", serviceDetails);
	   model.setViewName("showServiceDetails");
	   return model;
   }
   
}
