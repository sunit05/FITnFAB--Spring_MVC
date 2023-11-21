package com.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dto.Admin;
import com.jsp.dto.BranchManager;
import com.jsp.dto.Customer;
import com.jsp.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;


	@RequestMapping("/createcust")
	public ModelAndView createCust1() {
		ModelAndView modelAndView = new ModelAndView("custform.jsp");
		modelAndView.addObject("cust1", new Admin());
		return modelAndView;
	}

	@RequestMapping("/custadd")
	public ModelAndView custAdd(@ModelAttribute Customer customer) {
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		customerService.saveCustomer(customer);
		modelAndView.addObject("saved", customer.getName() + " saved successfully");
		return modelAndView;
	}

	
	@RequestMapping("/createCust")
	public ModelAndView gotoCreateCustomer() {
		ModelAndView modelAndView = new ModelAndView("customerForm.jsp");
		modelAndView.addObject("bm1", new BranchManager());
		return modelAndView;
	}

	@RequestMapping("/goToCustomerLogin")
	public ModelAndView goToLoginCustomer() {
		ModelAndView modelAndView = new ModelAndView("customerLogin.jsp");
		modelAndView.addObject("logincustomer", new Customer());
		return modelAndView;
	}

	@RequestMapping("/customerLogin")
	public ModelAndView cLogin(@ModelAttribute Customer customer) {
		Customer c = customerService.loginCust(customer.getEmail(), customer.getPassword());
		if (c != null) {
			ModelAndView modelAndView = new ModelAndView("customerDash.jsp");
			modelAndView.addObject("loginStatus", " admin login successfully");
			modelAndView.addObject("id", c.getId());

			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("home.jsp");
			modelAndView.addObject("loginStatus", " invalid username or password ");
			return modelAndView;
		}
	}

}
