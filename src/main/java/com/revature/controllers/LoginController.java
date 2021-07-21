package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.models.Users;
import com.revature.services.LoginService;
import com.revature.services.UserService;

public class LoginController {
	
	ObjectMapper om = new ObjectMapper();
	private LoginService ls = new LoginService();
	private UserService us = new UserService();
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		if(req.getMethod().equals("POST")) {
			
			BufferedReader reader = req.getReader();
			
			StringBuilder sb = new StringBuilder();
			
			String line = reader.readLine();
			
			while(line != null) {
				
				sb.append(line);
				line = reader.readLine();
			}
			
			String body = new String(sb);
			
			System.out.println(sb);
			
			LoginDTO lDTO = om.readValue(body, LoginDTO.class);
			
			System.out.println(lDTO.getErs_username() + lDTO.getErs_password());
			if(ls.login(lDTO.getErs_username(), lDTO.getErs_password())) {
				
				HttpSession ses = req.getSession();
				
				res.setStatus(200);
				
				Users user = us.getUser(lDTO.ers_username);
				String json = om.writeValueAsString(user);
				res.getWriter().print(json);
				
				ses.setAttribute("user", lDTO);
				ses.setAttribute("loggedin", true);
			}else {
				HttpSession ses = req.getSession(false);
				
				if(ses != null) {
					ses.invalidate();
				}
				
				res.setStatus(401);
				res.getWriter().print("Login Unsuccessful :(");
			}
		}
	}

}
