package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.BranchManagerDao;
import com.jsp.dto.BranchManager;

@Component
public class BranchManagerService {

	@Autowired
	private BranchManagerDao branchManagerDao;

	public BranchManager saveBranchManager(BranchManager branchManager) {
		if (branchManager != null && branchManager.getEmail()!=null && branchManager.getName()!=null
				 && branchManager.getEmail()!="" && branchManager.getName()!=""  && branchManager.getPassword()!="") {
			return branchManagerDao.saveBranchManager(branchManager);
		}
		return null;
	}

	public List<BranchManager> getAllBranchManagers() {
		return branchManagerDao.getAllBranchManagers();
	}

	public boolean deleteById(int id) {
		return branchManagerDao.deleteById(id);
	}
	
	public BranchManager updateBranchManagerById(int id,BranchManager branchManager) {
		BranchManager s=branchManagerDao.getBranchManagerById(id);
		s.setName(branchManager.getName());
		s.setEmail(branchManager.getEmail());
		s.setPassword(branchManager.getPassword());
		s.setStatus(branchManager.getStatus());
		return branchManagerDao.updateBranchManagerById(s);
	}
	
	public BranchManager loginBm(String email, String pw) {
		return branchManagerDao.loginBm(email, pw);
	}
	
	public BranchManager getBranchManagerById(int id) {
		return branchManagerDao.getBranchManagerById(id);
	}
}