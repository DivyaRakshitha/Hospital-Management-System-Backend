package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userinfo")
public class UserInfo {
	@Id
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private String userName;
	private String passWord;
	private String gender;
	private String dob;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public UserInfo(int id, String email, String firstName, String lastName, String userName, String passWord,
			String gender, String dob, int age) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.gender = gender;
		this.dob = dob;
		this.age = age;
	}
	public UserInfo() {
		super();
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userName=" + userName + ", passWord=" + passWord + ", gender=" + gender + ", dob=" + dob + ", age="
				+ age + "]";
	}
	
	 
	
}