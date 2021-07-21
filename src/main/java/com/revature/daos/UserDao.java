package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Users;
import com.revature.util.ConnectionUtil;

public class UserDao implements UserDaoInterface{

	@Override
	public Users getUsersUsername(String ers_username) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			ResultSet rs = null;
			
			String sql = "SELECT * FROM \"project1\".ers_users WHERE ers_username = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, ers_username);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Users u = new Users (
					
						rs.getInt("ers_users_id"),
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
