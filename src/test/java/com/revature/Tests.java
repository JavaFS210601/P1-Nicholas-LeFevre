package com.revature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.revature.daos.LoginDAO;
import com.revature.services.LoginService;
import com.revature.services.ReimbursmentService;

public class Tests {

	LoginService ls = new LoginService();
	ReimbursmentService rs = new ReimbursmentService();
	LoginDAO lDAO = new LoginDAO();
	
	public String ers_username;
	public String ers_password;
	
	@Test
	public void testValidLogin() {
		System.out.println("Testing Valid Login...");
		assertTrue(ls.login("nlefevre", "password"));
	}
	
	@Test
	public void testInvalidLogin() {
		System.out.println("Testing Invalid Login...");
		assertFalse(ls.login("rrr", "rrr"));
	}
	
	@Test 
	public void testAllTransactions() {
		System.out.println("Testing Transactions...");
		assertEquals(ArrayList.class, rs.getAllTransactions().getClass());
	}
	
	@Test 
	public void testUsername() {
		System.out.println("Testing Username...");
		assertEquals(ers_username = "nlefevre", lDAO.getUsername(ers_username));
	}
	
	@Test 
	public void testPassword() {
		System.out.println("Testing Password...");
		assertEquals(ers_password = "password", lDAO.getPassword(ers_password));
	}
	
	
}
