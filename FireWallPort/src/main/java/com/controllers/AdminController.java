package com.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	DcTeamRepository dcRepository;
	@Autowired
	CustomerDetailsRepository customerDetailsRepository;
    
	@GetMapping("/adminHome")
	public ModelAndView adminHome(Principal principal) {
		List<User> userList = (List<User>) userRepository.findAll();
		 User user = userRepository.getUserByUsername(principal.getName());
		ModelAndView model = new ModelAndView();
		model.setViewName("adminHome");
		model.addObject("user", user);
		model.addObject("userList", userList);
		return model;
	}

	@GetMapping("/view/{username}")
	public ModelAndView view(@PathVariable String username) {
		System.out.println("username view=" + username);
		User user = userRepository.getUserByUsername(username);
		ModelAndView model = new ModelAndView();
		model.addObject("user", user);
		model.setViewName("viewUser");
		return model;

	}

	@PostMapping("updateUser")
	public ModelAndView updeateUser(@ModelAttribute("user") @Valid User user, BindingResult br) {
		userRepository.save(user);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2");
		System.out.println("Role=" + user.getRole());
		System.out.println("active=" + user.isEnabled());
		ModelAndView model = new ModelAndView();
		model.addObject("msg", "Updated Successfully!!!!");
		model.setViewName("viewUser");
		return model;

	}

	@GetMapping("/viewRequests")
	public ModelAndView viewRequests(Principal principal) {
		User user = userRepository.getUserByUsername(principal.getName());
		ModelAndView model = new ModelAndView();
		model.setViewName("viewRequests");
		List<CustomerDetails> list =  (List<CustomerDetails>) customerDetailsRepository.findAll();
		model.addObject("list", list);
		model.addObject("user", user);
		return model;

	}

	@GetMapping("/admincreatecustomer/{id}")
	public ModelAndView admincreateCustomer(@PathVariable("id") int id,HttpServletRequest request) {
		CustomerDetails customerDetails = null;
		System.out.println("createCustomer dcteam="+id);

		//String username = request.getParameter("customername");

		
			//customerDetails = dcRepository.getCustomerByUserName(Integer.parseInt(username));
		                         Optional<CustomerDetails> customer = customerDetailsRepository.findById(id);
		                        if(customer.isPresent())
		                        {
		                        	 customerDetails = customer.get();
		                        }
		                        List<ServerDetailsTicket> t = customerDetails.getServerDetailsForTicket();
		                                                     List<IPList> iplist = customerDetails.getIplist();
		                                                     for(IPList list:iplist)
		                                                     {
		                                                    	 System.out.println("$$$$$$#################==="+list.getAction());
		                                                     }
	      for(ServerDetailsTicket k:t)
	      {
	    	  System.out.println("::::::::::::::::::::::::::::::::::::::::::::");
	    	  System.out.println(k.getHostname());
	      }
		String username=customerDetails.getUsername_cust_details();	
	    Customer cust = dcRepository.getOneCustomerByUserName(username);
	    List<ServerDetails> list = cust.getServerDetails();
		ModelAndView model = new ModelAndView();
		model.addObject("customerDetails", customerDetails);
		model.addObject("customer", new CustomerDetails());
		model.addObject("cust", cust);
		model.setViewName("admincustomerForm");
		return model;

	}

	@PostMapping("/saveDetails")
	public ModelAndView adminsaveDetails(@ModelAttribute("customer") @Valid CustomerDetails customer, BindingResult br,
			Principal principal, HttpServletRequest request) {
		String flag=null;
		//String[] hostname = request.getParameterValues("hostname");
		//String[] os = request.getParameterValues("os");
		//String[] privateip = request.getParameterValues("privateip");
		String username = request.getParameter("username");        
		String action = request.getParameter("action");
		         if(action.equals("approved"))
		         {
		        	 flag="approved";
		         }
		         else if(action.equals("rejected"))
		         {
		        	 flag="rejected";
		         }
		         else if(action.equals("hold"))
		         {
		        	 flag="hold";
		         }
					/*
					 * List<ServerDetails> list = new ArrayList<>(); for (int i = 0; i <
					 * hostname.length; i++) { ServerDetails serverDetails = new ServerDetails();
					 * serverDetails.setHostname(hostname[i]); serverDetails.setOs(os[i]);
					 * serverDetails.setPrivateip(privateip[i]); list.add(serverDetails); }
					 */
		customer.setUsername_cust_details(username);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+username);
		int id = customer.getId();
	    
		ModelAndView model = new ModelAndView();
		customer.setId(id);
		//customer.setTicketStatus(flag);
		customerDetailsRepository.updateTicketStatus(id, flag);
		customerDetailsRepository.updateAdminComments(id, customer.getAdminComment());
		//customerDetailsRepository.save(customer);
		model.addObject("msg", "Saved Successfully!!!");
		model.setViewName("admincustomerForm");
		return model;

	}

	@GetMapping("/usermanagement")
	public ModelAndView createuser(Principal principal) {
		User user = userRepository.getUserByUsername(principal.getName());
		ModelAndView model=new ModelAndView();
		model.setViewName("usermanagement");
		model.addObject("user", user);
		return model;
	}

	@PostMapping("/usertype")
	public ModelAndView usertype(HttpServletRequest request) {
		String usertype = request.getParameter("usertype");
		System.out.println("user type==========================" + usertype);
		return new ModelAndView("usertype");

	}

	@GetMapping("/getUser/{usertype}")
	public @ResponseBody String getUser(@PathVariable("usertype") String usertype) throws JsonProcessingException {
		String res = null;
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("Ajax workding==" + usertype);
		if (usertype.equals("customer")) {
			List<Customer> list = new ArrayList<>();

			List<Customer> customers = (List<Customer>) dcRepository.findAll();

			for (Customer customer : customers) {
				System.out.println("#################################################");
				System.out.println(customer.getCustomername());
				if (customer.getIsUserCreated().equals("0")) {
					System.out.println("inside inner if");
					list.add(customer);
				}
			}
			
			res = mapper.writeValueAsString(list);
		}
		else
		{
			res=mapper.writeValueAsString("noSubMenu");
		}

		return res;

	}

	@PostMapping("/getUserDetails")
	public ModelAndView getUserDetail(HttpServletRequest request) {
		Customer cust=null;
		System.out.println(
				"RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
		ModelAndView model=new ModelAndView();
		String usertype = request.getParameter("usertype");
		if(usertype.equals("customer"))
		{
		int id=Integer.parseInt(request.getParameter("customername"));
		System.out.println(request.getParameter("customername"));
		Optional<Customer> customer = dcRepository.findById(id);
		if(customer.isPresent())
		{ cust=new Customer();
			cust = customer.get();
		}
		model.addObject("customer",cust);
		}
		model.setViewName("creatCustomerForm");
		
		model.addObject("user", new User());
		return model;

	}
	@PostMapping("/createUser")
	public ModelAndView createUser(@ModelAttribute("user") @Valid User user,BindingResult br)
	{ Customer cust=null;
		System.out.println("create user controller");
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String rawPass=user.getPassword();
	       String encodedPass=encoder.encode(rawPass);
	       user.setPassword(encodedPass);
	       user.setEnabled(true);
	       Integer id=user.getId();
	       if(id!=null)
	       {
	       System.out.println("Teeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeest   "+id);
	       Optional<Customer> customer = dcRepository.findById(id);
	       if(customer.isPresent())
	       {
	    	   cust=customer.get();
	       }
	       
	       String isUserCreated="1";
	       cust.setIsUserCreated(isUserCreated);
	       cust.setUsername(user.getUsername());
	       dcRepository.save(cust);
	      System.out.println("11111111111111111111111111111111111111111111111111111111111111111111111");
	       }
	
		userRepository.save(user);
		
		return new ModelAndView("creatCustomerForm","msg","User Create Successfully!");
		
		
	}
}
