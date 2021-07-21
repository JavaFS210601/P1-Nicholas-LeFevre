package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionUtil;

public class LoginDAO implements LoginDAOInterface {
	
	public String getUsername(String ers_username) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			// might need to add the schema name if dont work
			String sql = "SELECT ers_username FROM \"project1\".ers_users WHERE ers_username = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ers_username);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String result = rs.getString("ers_username");
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getPassword(String ers_password) {
		try (Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "SELECT ers_password FROM \"project1\".ers_users WHERE ers_password = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ers_password);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String result = rs.getString("ers_password");
				return result;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
}