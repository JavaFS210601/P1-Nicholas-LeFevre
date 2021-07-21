package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursmentDao;
import com.revature.models.Reimbursements;

public class ReimbursmentService {

	ReimbursmentDao rd = new ReimbursmentDao();
	
	public void addTransaction(int reimb_type_id, String reimb_description, int reimb_amount) {
		
		if(reimb_type_id > 0 && reimb_type_id < 5) {
			rd.addReimbursment(reimb_type_id, reimb_description, reimb_amount);
		}else {
			System.out.println("Unable to add a new transaction");
		}
	}
	
	public void resolveTransaction(int reimb_type_id, int reimb_status_id) {
		if(reimb_status_id > 0 && reimb_status_id < 4) {
			rd.resolveTransaction(reimb_type_id, reimb_status_id);
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
