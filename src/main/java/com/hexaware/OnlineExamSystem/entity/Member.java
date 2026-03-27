package com.hexaware.OnlineExamSystem.entity;

public class Member {
	private int userId;
	private String name;
	private String email;
	public Member(int userId, String name, String email) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", name=" + name + ", email=" + email + "]";
	}
	
	public boolean equals(Object o) {
		Member m = (Member)o;
		return m.getUserId()==this.userId;
	}

	
	
	
}
