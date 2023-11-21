package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dto.BranchManager;
import com.jsp.dto.Customer;

@Component
public class CustomerDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Customer saveCustomer(Customer customer) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(customer);
		entityTransaction.commit();
		return customer;
	}

	public boolean deleteById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Customer customer = entityManager.find(Customer.class, id);
		if (customer != null) {
			entityTransaction.begin();
			entityManager.remove(customer);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Customer updateCustomerById(Customer customer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(customer);
		entityTransaction.commit();
		return customer;
	}

	public Customer getCustomerById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Customer.class, id);
	}

	public List<Customer> getAllCustomers() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("SELECT s FROM Customer s");
		List<Customer> customers = query.getResultList();
		return customers;
	}
	
	public Customer loginCust(String email, String pw) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "SELECT ad FROM BranchManager ad";
		Query query = entityManager.createQuery(sql);

		List<Customer> customers = query.getResultList();
		for (Customer a : customers) {
			if (email != null && pw != null) {
				if (email.equals(a.getEmail()) && pw.equals(a.getPassword())) {
					return a;
				}
			}
		}
		return null;
	}

}
