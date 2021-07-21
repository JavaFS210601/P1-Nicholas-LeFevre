package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ReimbursementDTO;
import com.revature.models.Reimbursements;
import com.revature.services.ReimbursmentService;

public class EmployeeController {

	private ReimbursmentService rs = new ReimbursmentService();
	private ObjectMapper om = new ObjectMapper();
	
	public void getPastTransactions(HttpServletResponse res) throws IOException {
		
		List<Reimbursements> list = rs.getPastTransactions();
		String json = om.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);
	}
	
	public void getPendingTransactions(HttpServletResponse res) throws IOException {
		
		List<Reimbursements> list = rs.getPendingTransactions();
		String json = om.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);
	}
	
	public void addTransaction(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		if(req.getMethod().equals("POST")) {
			
			BufferedReader bf = req.getReader();
			StringBuilder sb = new StringBuilder();
			String line = bf.readLine();
			
			while(line != null) {
				sb.append(line);
				line = bf.readLine();
			}
			
			String body = new String(sb);
			
			ReimbursementDTO rDTO = om.readValue(body, ReimbursementDTO.class);
			rs.addTransaction(rDTO.reimb_type_id, rDTO.reimb_description, rDTO.reimb_amount);
			res.setStatus(200);
			
			
		}
	}
	
}
