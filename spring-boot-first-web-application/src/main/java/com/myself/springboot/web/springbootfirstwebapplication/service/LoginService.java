package com.myself.springboot.web.springbootfirstwebapplication.service;

import org.hamcrest.text.IsEqualIgnoringCase;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;



@Component

public class LoginService {
	
	
	public boolean validateUser(String userid, String password) {
		// name = zarrar and password = dummy
		return (userid.equalsIgnoreCase("zarrar") ) && (password.equalsIgnoreCase("dummy"));
	}

}
