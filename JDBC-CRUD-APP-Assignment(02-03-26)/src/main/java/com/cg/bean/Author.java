package com.cg.bean;

public class Author {
	private int authorId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNo;

	public Author() {
	}

	public Author(String firstName, String middleName, String lastName, String phoneNo) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
	}

	// getters and setters
	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public String toString() {
		return "Name: " + getFirstName() + " " + getMiddleName() + " " + getLastName() + " Phone no: " + getPhoneNo();
	}
}
