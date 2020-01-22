package com.clustrex.application;

public class CustomerBookDetails {

	private String bookId;
	private String bookName;
	private String userName;
	private String dueDate;
	private String bookAuthor;
	private String samplePage;
	private String totalPage;
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getSamplePage() {
		return samplePage;
	}
	public void setSamplePage(String samplePage) {
		this.samplePage = samplePage;
	}
	public String getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}
	public String toString() {
		return userName + " " + bookId + " " + bookName + " " + dueDate + " " + bookAuthor + " " + samplePage + " " 
				+ totalPage;
	}
}