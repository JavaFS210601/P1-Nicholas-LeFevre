package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursements;
import com.revature.util.ConnectionUtil;

public class ReimbursmentDao implements ReimbursmentDaoInterface {

	@Override
	public void addReimbursment(int reimb_type_id, String reimb_description, int reimb_amount) {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "INSERT INTO ers_reimbursments"
					
					+ "(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)"
					+ "values(?, current_timestamp, null, ?, 1, 2, 1, ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimb_amount);
			ps.setString(2, reimb_description);
			ps.setInt(3, reimb_type_id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Unable to add Reimbursment");
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Reimbursements> viewPastTransaction() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ers_reimbursments WHERE reimb_status_id != 1;";
			
			ResultSet rs = null;
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			List<Reimbursements> list = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimbursements r = new Reimbursements (
						
						rs.getInt("reimb_id"), 
						rs.getString("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						);
				
				
				list.add(r);
			}
			
			return list;
			
		}catch (SQLException e) {
			System.out.println("Unable to view past transactions");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursements> viewPendingTransactions() {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ers_reimbursments WHERE reimb_status_id = 1;";
			
			ResultSet rs = null;
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			List<Reimbursements> list = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimbursements r = new Reimbursements (
						
						rs.getInt("reimb_id"), 
						rs.getString("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						);
				
				
				list.add(r);
			}
			
			return list;
			
		}catch (SQLException e) {
			System.out.println("Unable to view pending transactions");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursements> viewAllTransactions() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ers_reimbursments;";
			
			ResultSet rs = null;
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			List<Reimbursements> list = new ArrayList<>();
			
			while(rs.next()) {
				
				Reimbursements r = new Reimbursements (
						
						rs.getInt("reimb_id"), 
						rs.getString("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						);
				
				
				list.add(r);
			}
			
			return list;
			
		}catch (SQLException e) {
			System.out.println("Unable to view all transactions");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void resolveTransaction(int reimbursmentId, int reimbursmentStatus) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "UPDATE ers_reimbursments set reimb_status_id = ?, reimb_resolver = 2, reimb_resolved = current_timestamp WHERE reimb_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimbursmentStatus);
			ps.setInt(2, reimbursmentId);
			
		}catch (SQLException e) {
			System.out.println("Unable to resolve transaction");
			e.printStackTrace();
		}
		
	}

	public List<Reimbursements> filterByStatus(int reimb_status_id) {
try (Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "SELECT * FROM \"ers\".reimbursements WHERE reimb_status_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reimb_status_id);
			
			rs = ps.executeQuery();
			
			List<Reimbursements> list = new ArrayList<>();
			
			while(rs.next()) {
				Reimbursements r = new Reimbursements(
						rs.getInt("reimb_id"),
						rs.getString("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						);
				list.add(r);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
