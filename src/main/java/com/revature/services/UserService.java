package com.revature.services;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoInterface;
import com.revature.models.Users;

public class UserService {

	UserDaoInterface uDAO = new UserDao();
	
	public Users getUser(String ers_username) {
		return uDAO.getUsersUsername(ers_username);
	}
}
