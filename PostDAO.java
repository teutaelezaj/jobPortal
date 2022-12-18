package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Jobs;
import com.entity.Posts;
import com.DB.DBConnect;

public class PostDAO {
	
	private Connection conn;

	public PostDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addPosts(Posts u) {
		
		boolean p = false;
		
		try {
			
			String sql = "insert into posts(name, description) values(?,?) ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPostDesc());
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				p = true;
			}
			
		} catch (Exception e) {
			
		}
		return p;
	}
	
	public List<Posts> getAllPosts(){
		List<Posts> list = new ArrayList<Posts>();
		Posts p = null;
		
		try {
			String sql="select * from posts order by id desc";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				p=new Posts();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPostDesc(rs.getString(3));
				list.add(p);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
