package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.EmployeeController;
import com.revature.controllers.LoginController;
import com.revature.controllers.ManagerController;

public class MasterServlet {
	
	private EmployeeController ec = new EmployeeController();
	private ManagerController mc = new ManagerController();
	private LoginController lc = new LoginController();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("application/json");
		res.setStatus(404);
		
		String URI = req.getRequestURI().replace("/project1/", "");
		
		switch(URI) {
	
		}
	}

}
