package com.springmvc.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class User {
	
	
	@Size(min=2,max=50,message="Must be between 2 and 50 characters")
	@Pattern(regexp="^[a-zA-z0-9 ]+$",message="Must be alphanumeric, no special characters")
	private String firstName;
	
	
	@Size(min=2,max=50,message="Must be between 2 and 50 characters")
	@Pattern(regexp="^[a-zA-z0-9 ]+$",message="Must be alphanumeric, no special characters")
	private String lastName;
	
	@Size(min=7,max=50,message="Must be atleast 7 characters long")
	private String password;
	
	@Pattern(regexp="^[-a-zA-Z0-9_+]+(.[-a-zA-Z0-9_+]+)*@[-a-zA-Z]+(.[a-zA-Z]{1,}){1,4}$",message="Invalid email address")
	private String email;
	private String gender;
	
	
	public User() {
		
	}
	
	public User(String firstName,String lastName, String password,String email,String gender) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.password=password;
		this.email=email;
		this.gender=gender;
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
