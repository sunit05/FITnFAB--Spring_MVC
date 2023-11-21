package com.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.dao.BranchDao;
import com.jsp.dto.Branch;

@Component
public class BranchService {

	@Autowired
	private BranchDao branchDao;

	public Branch saveBranch(Branch branch) {
		if(branch.getAddress()!= null && branch.getAdmin()!=null && branch.getBranch_code()!=null && branch.getCity()!=null
				&& branch.getAddress()!="" && branch.getBranch_code()!="" && branch.getCity()!="" )
		{
			return branchDao.saveBranch(branch);
		}
		return null;
	}

	public List<Branch> getAllBranchs() {
		return branchDao.getAllBranchs();
	}

	public boolean deleteById(int id) {
		return branchDao.deleteById(id);
	}
	public Branch updateBranchById(int id,Branch branch) {
		Branch s=branchDao.getBranchById(id);
		
		s.setBranch_code(branch.getBranch_code());
		s.setCity(branch.getCity());
		return branchDao.updateBranchById(s);
	}


	
}
