package com.entity;

import com.entity.User;

public class Posts {
	
	private int id;
	private String name;
	private String postDesc;
	
	
	public Posts(int id, String name, String postDesc) {
		super();
		this.id = id;
		this.name = name;
		this.postDesc = postDesc;
	}
	
	public Posts() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPostDesc() {
		return postDesc;
	}
	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}
	
	

}
