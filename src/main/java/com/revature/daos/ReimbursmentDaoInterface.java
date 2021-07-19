package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursments;

public interface ReimbursmentDaoInterface {

	public void addReimbursment(int typeId, String description, int amount);
	
	public List<Reimbursments> viewPastTransaction();
	
	public List<Reimbursments> viewPendingTransactions();
	
	public List<Reimbursments> viewAllTransactions();
	
	public void resolveTransaction(int reimbursmentId, int reimbursmentStatus);
	
	
}
