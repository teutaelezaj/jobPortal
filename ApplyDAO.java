package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.Apply;
import com.entity.User;

public class ApplyDAO {
	
	private Connection conn;

	public ApplyDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean applyUser(Apply a) {
		boolean f = false;
		
		try {
			String sql = "insert into apply(name, qualification, email, password, role) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getName());
			ps.setString(2, a.getSchool());
			ps.setString(3, a.getExperience());
			ps.setString(4, a.getReason());
			
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}
			
		} catch (Exception  e) {
			e.printStackTrace();
		}
		return f;
	}

}