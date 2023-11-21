package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dto.Admin;
import com.jsp.dto.Branch;
import com.jsp.dto.BranchManager;

@Component
public class BranchManagerDao {

	@Autowired
	EntityManagerFactory entityManagerFactory;

	public BranchManager saveBranchManager(BranchManager branchManager) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(branchManager);
		entityTransaction.commit();
		return branchManager;
	}

	public boolean deleteById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		BranchManager branchManager = entityManager.find(BranchManager.class, id);
		if (branchManager != null) {
			entityTransaction.begin();
			entityManager.remove(branchManager);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public BranchManager updateBranchManagerById(BranchManager branchManager) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(branchManager);
		entityTransaction.commit();
		return branchManager;
	}

	public BranchManager getBranchManagerById(int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager.find(BranchManager.class, id);
	}

	public List<BranchManager> getAllBranchManagers() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("SELECT s FROM BranchManager s");
		List<BranchManager> branchManagers = query.getResultList();
		return branchManagers;
	}

	public BranchManager loginBm(String email, String pw) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String sql = "SELECT ad FROM BranchManager ad";
		Query query = entityManager.createQuery(sql);

		List<BranchManager> branchManagers = query.getResultList();
		for (BranchManager a : branchManagers) {
			if (email != null && pw != null) {
				if (email.equals(a.getEmail()) && pw.equals(a.getPassword())) {
					return a;
				}
			}
		}
		return null;
	}

}
