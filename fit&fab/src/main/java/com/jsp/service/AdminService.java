package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.AdminDao;
import com.jsp.dto.Admin;

@Component
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public Admin saveAdmin(Admin admin) {
		if (admin != null && admin.getEmail()!=null && admin.getName()!=null
				 && admin.getEmail()!="" && admin.getName()!=""  && admin.getPassword()!="") {
			return adminDao.saveAdmin(admin);
		}
		return null;
	}

	public List<Admin> getAllAdmins() {
		return adminDao.getAllAdmins();
	}

	public boolean deleteById(int id) {
		return adminDao.deleteById(id);
	}
	
	public Admin updateAdminById(int id,Admin admin) {
		Admin s=adminDao.getAdminById(id);
		s.setPassword(admin.getPassword());
		s.setName(admin.getName());
		s.setEmail(admin.getEmail());
		return adminDao.updateAdminById(s);
	}

	public boolean loginAdmin(String email, String pw) {
		return adminDao.loginAdmin(email, pw);
	}
}
