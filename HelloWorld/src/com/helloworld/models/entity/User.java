package com.helloworld.models.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Id
	private String id;
	private String username;
	private String password;
	private String password_confirmation;
	private String firstname;
	private String middlename;
	private String lastname;
	
	private String email; 
	private String job;
	private String department;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword_confirmation() {
		return password_confirmation;
	}
	public void setPassword_confirmation(String password_confirmation) {
		this.password_confirmation = password_confirmation;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public String getPassword() {
		return password;
	}
	
	public String getDepartment() {
		return department;
	}
	public String getEmail() {
		return email;
	}
	public String getJob() {
		return job;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFullname(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(firstname.trim());
		stringBuilder.append(' ');
		stringBuilder.append(middlename.trim());
		stringBuilder.append(' ');
		stringBuilder.append(lastname.trim());
		return stringBuilder.toString();
	}
}
