package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursmentDao;
import com.revature.models.Reimbursments;

public class ReimbursmentService {

	ReimbursmentDao rd = new ReimbursmentDao();
	
	public void addTransaction(int typeId, String description, int amount) {
		
		if(typeId > 0 && typeId < 5) {
			rd.addReimbursment(typeId, description, amount);
		}else {
			System.out.println("Unable to add a new transaction");
		}
	}
	
	public void resolveTransaction(int reimbursmentId, int reimbursmentStatus) {
		if(reimbursmentStatus > 0 && reimbursmentStatus < 4) {
			rd.resolveTransaction(reimbursmentId, reimbursmentStatus);
		}else {
			
		}
	}
	
	public List<Reimbursments> getPastTransactions(){
		return rd.viewPastTransaction();
	}
	
	public List<Reimbursments> getPendingTransactions(){
		return rd.viewPendingTransactions();
	}
	
	public List<Reimbursments> getAllTransactions(){
		return rd.viewAllTransactions();
	}
	
}
