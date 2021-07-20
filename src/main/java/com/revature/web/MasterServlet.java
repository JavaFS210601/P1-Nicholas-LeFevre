package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.EmployeeController;
import com.revature.controllers.LoginController;
import com.revature.controllers.ManagerController;

public class MasterServlet extends HttpServlet{
	
	private EmployeeController ec = new EmployeeController();
	private ManagerController mc = new ManagerController();
	private LoginController lc = new LoginController();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("application/json");
		res.setStatus(404);
		
		String URI = req.getRequestURI().replace("/project1/", "");
		
		switch(URI) {
	
		case "pastTransactions":
			ec.getPastTransactions(res);
			break;
			
		case "pendingTransaction":
			ec.getPendingTransactions(res);
			break;
			
		case "addTransaction":
			ec.addTransaction(req, res);
			break;
			
		case "getAllTransactions":
			mc.getAllTransactions(res);
			break;
			
		case "resolveTransaction":
			mc.resolveTransaction(req, res);
			break;
			
		case "login":
			lc.login(req, res);
		}
		
	}
	
	protected void doPOST(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
