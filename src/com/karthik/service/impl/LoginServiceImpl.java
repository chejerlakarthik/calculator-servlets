package com.karthik.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.karthik.model.User;
import com.karthik.service.LoginService;

public class LoginServiceImpl implements LoginService {
	
	private Map<String, String> users = new HashMap<String, String>();
	
	public LoginServiceImpl(){
		users.put("karthik", "Karthik Chejerla");
		users.put("aarthi", "Aarthi Sundar");
		users.put("daksha", "Daksha Chejerla");
	}

	@Override
	public boolean authenticate(String username, String password) {
		if (!(username.isEmpty() && password.isEmpty()))
			return true;
		return false;
	}
	
	public User getUserDetails(String userName) {
		User user = new User();
		user.setUserName(userName);
		user.setFullName(users.get(userName));
		return user;
	}

}
