package com.entity;

public class Apply {
	
	private int id;
	private String name;
	private String school;
	private String experience;
	private String reason;
	
	
	public Apply(String name, String school, String experience, String reason) {
		super();
		this.name = name;
		this.school = school;
		this.experience = experience;
		this.reason = reason;
	}

	public Apply() {
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

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
}