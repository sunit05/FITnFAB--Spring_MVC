package com.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.dto.BranchManager;
import com.jsp.dto.Event;
import com.jsp.service.AdminService;
import com.jsp.service.BranchManagerService;
import com.jsp.service.BranchService;
import com.jsp.service.EventService;

@Controller
public class BranchManagerController {

	@Autowired
	AdminService adminService;

	@Autowired
	BranchManagerService branchManagerService;

	@Autowired
	BranchService branchService;

	@Autowired
	EventService eventService;

	@RequestMapping("/createBm")
	public ModelAndView gotoCreateBranchManager() {
		ModelAndView modelAndView = new ModelAndView("bmForm.jsp");
		modelAndView.addObject("bm1", new BranchManager());
		return modelAndView;
	}
	
	int a;
	@RequestMapping("/bmadd")
	public ModelAndView saveBm(@ModelAttribute BranchManager branchManager) {
		ModelAndView modelAndView = new ModelAndView("home.jsp");
		branchManagerService.saveBranchManager(branchManager);
		modelAndView.addObject("saved", branchManager.getName() + " is saved successfully");
		return modelAndView;
	}

	@RequestMapping("/goToBMLogin")
	public ModelAndView goToBMlogin() {
		ModelAndView modelAndView = new ModelAndView("bmLogin.jsp");
		modelAndView.addObject("loginBm", new BranchManager());
		return modelAndView;
	}

	@RequestMapping("/BmLogin")
	public ModelAndView bmlogin1(@ModelAttribute BranchManager branchManager) {
		BranchManager b = branchManagerService.loginBm(branchManager.getEmail(), branchManager.getPassword());
		if (b != null) {
			ModelAndView modelAndView = new ModelAndView("bmDash.jsp");
			modelAndView.addObject("loginStatus", " admin login successfully");
			modelAndView.addObject("id", b.getId());
			a=b.getId();
			System.out.println(a);
		
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("home.jsp");
			modelAndView.addObject("loginStatus", " invalid username or password ");
			return modelAndView;
		}
	}

	@RequestMapping("/createEvent")
	public ModelAndView createEvent1() {
		ModelAndView modelAndView = new ModelAndView("eventCreate.jsp");
		modelAndView.addObject("event1", new Event());
		System.out.println(a);
		modelAndView.addObject("bmid",a);
		return modelAndView;
	}

	@RequestMapping("/eventadd")
	public ModelAndView saveEvent(@ModelAttribute Event event, @RequestParam String bmid) {
		ModelAndView modelAndView = new ModelAndView("bmDash.jsp");
		int a = Integer.parseInt(bmid);
		BranchManager branchManager = branchManagerService.getBranchManagerById(a);
		event.setBranchManager(branchManager);
		eventService.saveEvent(event);
		return modelAndView;
	}
	
	@RequestMapping("viewAllEvents")
	public ModelAndView getAllEvents() {
		ModelAndView modelAndView = new ModelAndView("eventsViewAll.jsp");
		List<Event> events  = eventService.getAllEvents();
		modelAndView.addObject("event", events);
		return modelAndView;
	}
	
	@RequestMapping("/deleteevent")
	public ModelAndView deleteEventById(@RequestParam(name = "eventid") int eid) {
		ModelAndView modelAndView = new ModelAndView("eventsViewAll.jsp");
		eventService.deleteById(eid);
		modelAndView.addObject("eventdelete", "event " + eid + " deleted");
		return modelAndView;
	}
	
	
//	===================================================================================================
	
//	customer controller
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}