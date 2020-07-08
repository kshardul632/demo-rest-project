package com.xangars.restdemoone.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
//	@Pattern(regexp = "([a-zA-Z]{2})+", message = "First name should contain only alphabets. First name should minimum 2 alphabets")
	@Size(min=2, message = "First name should have atleast 2 alphabets")
	private String firstName;
	
	@Column(name = "last_name")
//	@Pattern(regexp = "([a-zA-Z]{2})+", message = "Last name should contain only alphabets. First name should minimum 2 alphabets")
	@Size(min=2, message = "Last name should have atleast 2 alphabets")
	private String lastName;
	
	@Email(message = "Invalid email")
//	@Email(regexp = "[a-zA-Z_][a-zA-Z0-9\\.]@[a-zA-Z0-0\\.]\\.[a-zA-Z\\.]+", message = "Invalid email")
	private String email;
	
	@Pattern(regexp = "[7-9][0-9]{9}", message = "Invalid mobile no")
	private String mobile;
	
	public Student() {}

	public Student(String firstName, String lastName, String email, String mobile) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}
		
}
