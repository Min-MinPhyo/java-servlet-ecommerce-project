package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;

public class UserDao {
	private Connection con;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	
	public User userLogin(String email, String password) {
		User user=null;
		
		
		try {
	
			String query="select * from user where email=? and password=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2,password);
		
		
			ResultSet rs=ps.executeQuery();
	
		
			if(rs.next()) {
				 user=new User();
				 user.setId(rs.getInt(1));
				 user.setName(rs.getString(2));
				 user.setEmail(rs.getString(3));
				 user.setPassword(rs.getString(4));
	          
	             
	
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	
	
	
	
	

}
