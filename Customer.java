package com.clustrex.application;


public class Customer {
	
	private String userName;
	private String firstName;
	private String lastName;
	private String bookId;
	private String dueDate;
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
	public String getDueDate() {
		return dueDate;
	}
	public void setDuedate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	
}
