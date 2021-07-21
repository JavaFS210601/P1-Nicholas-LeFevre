package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursements;

public interface ReimbursmentDaoInterface {

	public void addReimbursment(int reimb_type_id, String reimb_description, int reimb_amount);
	
	public List<Reimbursements> viewPastTransaction();
	
	public List<Reimbursements> viewPendingTransactions();
	
	public List<Reimbursements> viewAllTransactions();
	
	public List<Reimbursements> filterByStatus(int reimb_status_id); 
	
	public void resolveTransaction(int reimb_id, int reimb_status_id);
	
	
}
