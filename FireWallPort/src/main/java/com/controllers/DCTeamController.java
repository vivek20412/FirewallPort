package com.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Customer;
import com.bean.ServerDetails;
import com.bean.User;
import com.dao.DcTeamRepository;
import com.dao.UserRepository;

@Controller
@RequestMapping("/dcteam")
public class DCTeamController {
	@Autowired
    DcTeamRepository dcRepository;
	@Autowired UserRepository userRepository;
	
	@GetMapping("/home")
	public ModelAndView home(Principal principal)
	{
		User user = userRepository.getUserByUsername(principal.getName());
		List<Customer> list =  (List<Customer>) dcRepository.findAll();
		ModelAndView model=new ModelAndView();
		model.addObject("user", user);
		model.addObject("list",list);
		model.setViewName("dchome");
		return model;
	}
	@PostMapping("/createcustomer")
	public ModelAndView createCustomer(HttpServletRequest request,Principal principal)
	{
		Customer customerDetails=null;
		System.out.println("createCustomer dcteam");
		User user = userRepository.getUserByUsername(principal.getName());
		String username = request.getParameter("customername");
		
		if(!username.equals("select"))
		{
			customerDetails=dcRepository.getCustomerByUserName(Integer.parseInt(username));
			System.out.println("id @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+customerDetails.getId());
		}
		System.out.println("#########################################################################");
		System.out.println("customername==="+username);
		ModelAndView model=new ModelAndView();
		model.addObject("customerDetails", customerDetails);
		model.addObject("customer", new Customer());
		model.addObject("user", user);
		model.setViewName("customerForm");
		return model;
		
	}
	@PostMapping("/saveDetails")
	public ModelAndView saveDetails(@ModelAttribute("customer") @Valid Customer customer,BindingResult br,Principal principal,HttpServletRequest request)
	{
		String[] hostname = request.getParameterValues("hostname");
		String[] os = request.getParameterValues("os");
		String[] privateip = request.getParameterValues("privateip");
		List<ServerDetails> list=new ArrayList<>();
		for(int i=0;i<hostname.length;i++)
		{
			ServerDetails serverDetails=new ServerDetails();
			serverDetails.setHostname(hostname[i]);
			serverDetails.setOs(os[i]);
			serverDetails.setPrivateip(privateip[i]);
			list.add(serverDetails);		
		}
		customer.setServerDetails(list);
		customer.setIsUserCreated("0");
		int id = customer.getId();
		ModelAndView model=new ModelAndView();
		customer.setId(id);
		dcRepository.save(customer);
		model.addObject("msg", "Saved Successfully!!!");
		model.setViewName("customerForm");
		return model;
		
	}
}
