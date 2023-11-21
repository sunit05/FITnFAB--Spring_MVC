package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dto.Admin;

@Component
public class AdminDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public Admin saveAdmin(Admin admin) {

		if (admin != null) {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();
			entityManager.persist(admin);
			entityTransaction.commit();
		}
		return admin;
	}

	public boolean deleteById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Admin admin = entityManager.find(Admin.class, id);
		if (admin != null) {
			entityTransaction.begin();
			entityManager.remove(admin);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Admin updateAdminById(Admin admin) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();
		return admin;
	}

	public Admin getAdminById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(Admin.class, id);
	}

	public List<Admin> getAllAdmins() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("SELECT s FROM Admin s");
		List<Admin> admins = query.getResultList();
		return admins;
	}
	
	@SuppressWarnings("unchecked")
	public boolean loginAdmin(String email, String pw) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "SELECT ad FROM Admin ad";
		Query query = entityManager.createQuery(sql);

		List<Admin> admins = query.getResultList();
		for (Admin a : admins) {
			if (email.equals(a.getEmail()) && pw.equals(a.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
