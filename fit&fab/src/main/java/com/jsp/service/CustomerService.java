package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.CustomerDao;
import com.jsp.dto.Customer;

@Component
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public Customer saveCustomer(Customer customer) {
		if (customer != null) {
			return customerDao.saveCustomer(customer);
		}
		return null;
	}

	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	public boolean deleteById(int id) {
		return customerDao.deleteById(id);
	}
	
	public Customer updateCustomerById(int id,Customer customer) {
		Customer s=customerDao.getCustomerById(id);
		s.setName(customer.getName());
		s.setPassword(customer.getPassword());
		s.setPay_status(customer.getPay_status());
		return customerDao.updateCustomerById(s);
	}

	public Customer loginCust(String email, String pw) {
		return customerDao.loginCust(email, pw);
	}

}
