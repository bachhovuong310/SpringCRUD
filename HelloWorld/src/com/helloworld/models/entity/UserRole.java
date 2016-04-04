package com.helloworld.models.entity;

public enum UserRole {
	USER("USER"),
	ADMIN("ADMIN");
	String role;
	private UserRole(String role) {
		this.role = role;
	}
	public String getRoleName(){
		return role;
	}
}
