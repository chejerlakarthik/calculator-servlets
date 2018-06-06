package com.karthik.service;

import com.karthik.model.User;

public interface LoginService {
	
	public boolean authenticate(String username, String password);
	
	public User getUserDetails(String userName);
}
