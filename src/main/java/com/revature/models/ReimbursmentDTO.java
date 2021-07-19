package com.revature.models;

public class ReimbursmentDTO {

	public int reimbursmentId;
	public int typeId;
	public int reimbursmentStatus;
	public int amount;
	public String description;
	
	
	public ReimbursmentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReimbursmentDTO(int typeId, int amount, String description) {
		super();
		this.typeId = typeId;
		this.amount = amount;
		this.description = description;
	}


	public ReimbursmentDTO(int reimbursmentId, int reimbursmentStatus) {
		super();
		this.reimbursmentId = reimbursmentId;
		this.reimbursmentStatus = reimbursmentStatus;
	}
	
	
	
	
	
	
	
}
