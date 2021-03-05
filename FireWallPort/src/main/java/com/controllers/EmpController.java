package com.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.bean.ServerDetails;
import com.bean.User;
import com.dao.CustomerDetailsRepository;
import com.dao.DcTeamRepository;
import com.dao.EmpRepository;
import com.dao.UserRepository;

@Controller
@RequestMapping("/employee")
public class EmpController {

	@Autowired
	EmpRepository empRepository;
	@Autowired
	DcTeamRepository dcRepository;
	@Autowired
	CustomerDetailsRepository customerDetailsRepository;
	@Autowired UserRepository userRepository;

	@GetMapping("/empHome")
	public String empHome(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "empHome";
	}

	@PostMapping("/createUser")
	public ModelAndView createUser(@ModelAttribute("user") @Valid User user, BindingResult br) {
		System.out.println("create user controller");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPass = user.getPassword();
		String encodedPass = encoder.encode(rawPass);
		user.setPassword(encodedPass);
		user.setEnabled(true);
		empRepository.save(user);

		return new ModelAndView("empHome", "msg", "User Create Successfully!");

	}

	@GetMapping("/request")
	public ModelAndView request(Principal principal) {
		List<Customer> list = (List<Customer>) dcRepository.findAll();
		                      User user = userRepository.getUserByUsername(principal.getName());
		for (Customer cust : list) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println(cust.getCustomername());
		}
		ModelAndView model=new ModelAndView();
		model.addObject("list", list);
		model.addObject("user", user);
		model.setViewName("request");
		return model;
		
	}

	@PostMapping("/requestlist")
	public ModelAndView getRequestList(HttpServletRequest request) {
		Customer customerDetails = null;
		System.out.println("createCustomer dcteam");

		String username = request.getParameter("customername");

		if (!username.equals("select")) {
			customerDetails = dcRepository.getCustomerByUserName(Integer.parseInt(username));
			System.out.println("id @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"
					+ customerDetails.getServerDetails());
		}
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		List<ServerDetails> server = customerDetails.getServerDetails();
		for (ServerDetails s : server) {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.out.println(s.getHostname());
		}

		System.out.println("#########################################################################");
		System.out.println("customername===" + username);
		ModelAndView model = new ModelAndView();
		model.addObject("customerDetails", customerDetails);
		model.addObject("customer", new Customer());
		model.setViewName("firewallcustomerForm");
		return model;

	}

	@PostMapping("/savePublicIPDetails")
	public ModelAndView savePublicDetails(@ModelAttribute("customer") @Valid Customer customer, BindingResult br,
			HttpServletRequest request) {

		String[] hostname = request.getParameterValues("hostname");
		String[] os = request.getParameterValues("os");
		String[] privateip = request.getParameterValues("privateip");

		String[] publicip = request.getParameterValues("publicip");
		String[] nat = request.getParameterValues("nat");
		String[] id = request.getParameterValues("serverDetails_id");

		List<ServerDetails> list = new ArrayList<>();
		for (int i = 0; i < publicip.length; i++) {
			ServerDetails serverDetails = new ServerDetails();

			serverDetails.setHostname(hostname[i]);
			serverDetails.setOs(os[i]);
			serverDetails.setPrivateip(privateip[i]);
			serverDetails.setPublicip(publicip[i]);
			serverDetails.setNat(nat[i]);
			serverDetails.setId(Integer.parseInt(id[i]));
			list.add(serverDetails);
		}
		String isUserCreated = "0";
		customer.setIsUserCreated(isUserCreated);
		customer.setServerDetails(list);
		ModelAndView model = new ModelAndView();
		dcRepository.save(customer);
		model.addObject("msg", "Saved Successfully!!!");
		model.setViewName("firewallcustomerForm");
		return model;

	}

	@GetMapping("/ticketRequest")
	public ModelAndView ticketRequest(Principal principal) {
		List<CustomerDetails> list = (List<CustomerDetails>) customerDetailsRepository.findAll();
		String username=principal.getName();
		User user = userRepository.getUserByUsername(username);
		ModelAndView model = new ModelAndView();
		model.setViewName("ticketRequest");
		model.addObject("list", list);
		model.addObject("user", user);
		return model;
	}

	@GetMapping("/viewSingleRequest/{service_no}")
	public ModelAndView showServiceDetails(@PathVariable("service_no") String service_no,Principal principal) {
		CustomerDetails serviceDetails = customerDetailsRepository.getDetailsByServiceno(service_no);
		User user = userRepository.getUserByUsername(principal.getName());
		ModelAndView model = new ModelAndView();
		model.addObject("serviceDetails", serviceDetails);
		model.addObject("user", user);
		model.setViewName("viewSingleRequest");
		return model;
	}

	@GetMapping("/configure/{id}")
	public ModelAndView configure(@PathVariable("id") int id,Principal principal) {
		CustomerDetails customerDetails = null;
		Optional<CustomerDetails> cstDetails = customerDetailsRepository.findById(id);
		if (cstDetails.isPresent()) {
			customerDetails = cstDetails.get();
		}
		User user = userRepository.getUserByUsername(principal.getName());
		ModelAndView model = new ModelAndView();
		model.addObject("customerDetails", customerDetails);
		model.addObject("customer", new CustomerDetails());
		model.addObject("user", user);
		model.setViewName("configure");
		return model;

	}

	@PostMapping("/saveConfiguration")
	public ModelAndView addDescription(@ModelAttribute("customer") @Valid CustomerDetails customer, BindingResult br,
			Principal principal, HttpServletRequest request) {
		System.out.println();
		int id = customer.getId();
		String configurationDesc = customer.getConfigurationDesc();
		System.out.println("configurationDesc====" + configurationDesc);

		ModelAndView model = new ModelAndView();
		customer.setId(id);
		// customer.setTicketStatus(flag);
		System.out.println("iddddddddddddddddddddd===" + id);
		customerDetailsRepository.updateTicketDesc(id, configurationDesc);
		model.addObject("msg", "Description Added");
		model.setViewName("configure");
		return model;

	}
}
