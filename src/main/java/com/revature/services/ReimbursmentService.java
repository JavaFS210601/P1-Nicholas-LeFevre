package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursmentDao;
import com.revature.models.Reimbursements;

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
	
	public List<Reimbursements> getPastTransactions(){
		return rd.viewPastTransaction();
	}
	
	public List<Reimbursements> getPendingTransactions(){
		return rd.viewPendingTransactions();
	}
	
	public List<Reimbursements> getAllTransactions(){
		return rd.viewAllTransactions();
	}

	public List<Reimbursements> filterByStatus(int reimb_status_id) {
		if(reimb_status_id > 0 && reimb_status_id < 4) {
			return rd.filterByStatus(reimb_status_id);
		} else {
			return null;
		}
	}
	
}
