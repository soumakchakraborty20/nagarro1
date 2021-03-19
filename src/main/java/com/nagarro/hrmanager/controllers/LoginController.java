package com.nagarro.hrmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.hrmanager.service.LoginService;

@Controller
public class LoginController {
	
	@GetMapping("/Login")
	public String Login() {
		
		System.out.println("login page");
		return "LoginForm";
	}
	
	@Autowired
	public LoginService loginService;
	
	@PostMapping("/employeeList")
	public ModelAndView checkUser(@RequestParam("userId") int userId,
			@RequestParam("password") String userPassword) {

		
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("userId",userId);
		//modelView.addObject("password",userPassword);
		boolean userExists = loginService.checkLogin(userId, userPassword);
		
		if(userExists) {
	
			modelView.setViewName("redirect:/employeeList");
		}else {
			modelView.setViewName("redirect:/Login");
			modelView.addObject("errorMessage","invalid credentials");


		}
		return modelView;
	}

}
