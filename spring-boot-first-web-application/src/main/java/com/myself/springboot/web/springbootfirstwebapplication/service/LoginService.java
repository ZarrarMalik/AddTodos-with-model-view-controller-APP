package com.myself.springboot.web.springbootfirstwebapplication.service;

import org.hamcrest.text.IsEqualIgnoringCase;
import org.springframework.stereotype.Component;



@Component
public class LoginService {
	
	
	public boolean validateUser(String userid, String password) {
		// name = Munro and password = dummy
		return (userid.equalsIgnoreCase("munro") ) && (password.equalsIgnoreCase("dummy"));
	}

}
