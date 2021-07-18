package com.revature.services;

public class LoginService {

	public boolean login(String username, String password) {


		if(username.equals("NickLeFevre") && password.equals("password")) {
			return true;
		}
		return false;
	}

}
