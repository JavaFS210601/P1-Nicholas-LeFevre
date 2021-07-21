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

public class ManagerController {

	private ReimbursmentService rs = new ReimbursmentService();
	private ObjectMapper om = new ObjectMapper();
	
	public void getAllTransactions(HttpServletResponse res) throws IOException {
		
		List<Reimbursements> list = rs.getAllTransactions();
		String json = om.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);
	}
	
	public void getTransactionByStatus(HttpServletRequest req, HttpServletResponse res) throws IOException{
		if(req.getMethod().equals("POST")) {
			BufferedReader reader = req.getReader();
			
			StringBuilder sb = new StringBuilder();
			
			String line = reader.readLine();
			
			while(line != null) {
				sb.append(line);
				line = reader.readLine();
			}
			
			String body = new String(sb);
			
			ReimbursementDTO rDTO = om.readValue(body, ReimbursementDTO.class);
			
			List<Reimbursements> list = rs.filterByStatus(rDTO.reimb_status_id);
			
			String json = om.writeValueAsString(list);
			
			res.getWriter().print(json);
			
			res.setStatus(200);
		}
	}
	
	public void resolveTransaction(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
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
			rs.resolveTransaction(rDTO.reimb_id, rDTO.reimb_status_id);
			res.setStatus(200);
		}
	}
}
