package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dto.Admin;
import com.jsp.dto.Branch;
import com.jsp.dto.BranchManager;
import com.jsp.service.AdminService;
import com.jsp.service.BranchManagerService;
import com.jsp.service.BranchService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	BranchManagerService branchManagerService;

	@Autowired
	BranchService branchService;

	@RequestMapping("/createadmin")
	public ModelAndView createAdmin1() {
		ModelAndView modelAndView = new ModelAndView("adminform.jsp");
		modelAndView.addObject("admin1", new Admin());
		return modelAndView;
	}

	@RequestMapping("/adminadd")
	public ModelAndView adminAdd(@ModelAttribute Admin admin) {
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		adminService.saveAdmin(admin);
		modelAndView.addObject("saved", admin.getName() + " saved successfully");
		return modelAndView;
	}

	@RequestMapping("/goToAdminLogin")
	public ModelAndView goToAdminlogin() {
		ModelAndView modelAndView = new ModelAndView("adminLogin.jsp");
		modelAndView.addObject("loginadmin", new Admin());
		return modelAndView;
	}

	@RequestMapping("/adminLogin")
	public ModelAndView adminlogin1(@ModelAttribute Admin admin) {
		boolean b = adminService.loginAdmin(admin.getEmail(), admin.getPassword());
		if (b) {
			ModelAndView modelAndView = new ModelAndView("adminDashboard.jsp");
			modelAndView.addObject("loginStatus", " admin login successfully");
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("home.jsp");
			modelAndView.addObject("loginStatus", " invalid username or password ");
			return modelAndView;
		}
	}

	@RequestMapping("viewAllBM")
	public ModelAndView getAllBranchManager() {
		ModelAndView modelAndView = new ModelAndView("viewAllBranchManagers.jsp");
		List<BranchManager> branchManagers = branchManagerService.getAllBranchManagers();
		modelAndView.addObject("bms", branchManagers);
		return modelAndView;
	}

	@RequestMapping("viewAllB")
	public ModelAndView getAllBranch() {
		ModelAndView modelAndView = new ModelAndView("viewAllBranches.jsp");
		List<Branch> branches = branchService.getAllBranchs();
		modelAndView.addObject("branch", branches);
		return modelAndView;
	}

	@RequestMapping("/gotoAddBranch")
	public ModelAndView createbranch() {
		ModelAndView modelAndView = new ModelAndView("addBranch.jsp");
		modelAndView.addObject("branch1", new Branch());
		return modelAndView;
	}

	@RequestMapping("/addBranch")
	public ModelAndView branchAdd(@ModelAttribute Branch branch) {
		ModelAndView modelAndView = new ModelAndView("adminDashboard.jsp");
		branchService.saveBranch(branch);
		modelAndView.addObject("branch1", "Branch added successfully");
		return modelAndView;
	}

	@RequestMapping("/deletebranch")
	public ModelAndView deleteBranchById(@RequestParam(name = "id") int id) {
		ModelAndView modelAndView = new ModelAndView("viewAllBranches.jsp");
		branchService.deleteById(id);
		modelAndView.addObject("branchdelete", "branch" + id + " deleted");
		return modelAndView;
	}
}