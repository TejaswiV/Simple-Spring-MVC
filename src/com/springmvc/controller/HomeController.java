package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.bean.User;

@Controller
@RequestMapping({"/","home"})
public class HomeController {
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String displayHomePage(Model model){
		
		System.out.println("home controller");
		model.addAttribute("user",new User());
		return "home";
	}
	
}
