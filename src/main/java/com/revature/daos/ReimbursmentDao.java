package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursments;
import com.revature.util.ConnectionUtil;

public class ReimbursmentDao implements ReimbursmentDaoInterface {

	@Override
	public List<Reimbursments> getAllReimbursments() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ers_reimbwursments;";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			List<Reimbursments> reimbursmentList = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimbursments r = new Reimbursments(
						
						rs.getString("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						
						);
				reimbursmentList.add(r);
			}
			
			return reimbursmentList;
			
		}catch(SQLException e) {
			System.out.println("Failed to get all reimbursments");
			e.printStackTrace();
		}
		return null;
	}

}
