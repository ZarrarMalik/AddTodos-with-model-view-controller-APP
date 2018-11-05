
	package com.myself.springboot.web.springbootfirstwebapplication.controller;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myself.springboot.web.springbootfirstwebapplication.service.LoginService;


	@Controller
	public class LoginController {
		@Autowired
		LoginService service ;
		
		
		@RequestMapping(value = "/login", method=RequestMethod.GET)
	//	@ResponseBody
		String showLogInPage(ModelMap model) {
		//	model.put("name", name);
			
			
		//	System.out.println("The name we entered is" + name);
			
			return "login";
		}
		
		@RequestMapping(value = "/login", method=RequestMethod.POST)
		String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {
			boolean isValidUser= service.validateUser(name, password);
			if(!isValidUser) {
				
				model.put("errorMessage", "Invalid Cradentials");
			return "login";
			
			
			}
			model.put("name", name);
			model.put("password", password);
			
		//	System.out.println("The name we entered is" + name);
			
			return "welcome";
		}
		
	}


