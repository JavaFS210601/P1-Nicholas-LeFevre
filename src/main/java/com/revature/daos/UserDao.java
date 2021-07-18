package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Users;
import com.revature.util.ConnectionUtil;

public class UserDao implements UserDaoInterface{

	
	public Users getUsersUsername(String username) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ers_users";
			
			ResultSet rs = null;
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Users u = new Users (
					
						rs.getInt("ers_user_id"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("user_email"),
						rs.getInt("user_role_id")
						);
				
				return u;
						
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
