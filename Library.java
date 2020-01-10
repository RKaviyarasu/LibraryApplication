package com.clustrex.application;

import java.util.Calendar;
import java.util.Map;

public class Library {
	private String bookId;
	private String bookName;
	private String bookAuthor;
	private int sampleContentLength;
	private int fullContentLength;
	private String userName;
	private String exitChoice;
	private String choiceOperation;
	private String updateChoice;
	private String updateChoiceValue;
	private String firstName;
	private String lastName;
	private String dueDate;
	private String currentDate;
	private Calendar calendar;
	private String samplePage;
	private Map<String, String>bookDetails;
	public Library() {
		
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setSampleContentLength(int sampleContentLength) {
		this.sampleContentLength = sampleContentLength;
	}
	public int getSampleContentLength() {
		return sampleContentLength;
	}
	public void setFullContentLength(int fullContentLength) {
		this.fullContentLength = fullContentLength;
	}
	public int getFullContentLength() {
		return fullContentLength;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setExitChoice(String exitChoice) {
		this.exitChoice = exitChoice;
	}
	public String getExitChoice() {
		return exitChoice;
	}
	public void setChoiceOperation(String choiceOperation) {
		this.choiceOperation = choiceOperation;
	}
	public String getChoiceOperation() {
		return choiceOperation;
	}
	public void setUpdateChoice(String updateChoice) {
		this.updateChoice = updateChoice;
	}
	public String getUpdateChoice() {
		return updateChoice;
	}
	public void setUpdateChoiceValue(String updateChoiceValue) {
		this.updateChoiceValue = updateChoiceValue;
	}
	public String getUpdateChoiceValue() {
		return updateChoiceValue;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	public Calendar getCalendar() {
		return calendar;
	}
	public void setSamplePage(String samplePage) {
		this.samplePage = samplePage;
	}
	public String getSamplePage() {
		return samplePage;
	}
	public void setBookDetails(Map<String, String>bookDetails) {
		this.bookDetails = bookDetails;
	}
	public Map<String, String> getBookDetails(){
		return bookDetails;
	}
}