package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.models.Users;

public class UserService {

	UserDao uDAO = new UserDao();
	
	public Users getUser(String username) {
		return uDAO.getUsersUsername(username);
	}
}
