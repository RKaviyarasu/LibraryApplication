package com.clustrex.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.InputMismatchException;

public class GettingInput {
	
	BufferedReader bufferedReader;
	public GettingInput(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}
	
	public String getUserChoice() {
		String userChoice = null;
		try {
			userChoice = bufferedReader.readLine();
		}catch(Exception e) {
			System.out.println("Enter the Input");
			getUserChoice();
		}
		return (userChoice.equals(""))?getUserChoice():userChoice;
	}
	
	public String getExitChoice() throws Exception {
		return bufferedReader.readLine();
	}
	
	public String getBookName() {
		String bookName = null;
		try {
			System.out.println("Enter the Book Name: ");
			bookName = bufferedReader.readLine();
		}catch(IOException e) {
			System.out.println("Enter the input");
			getBookName();
		}
		return (bookName.equals("")) ? getBookName() : bookName;
	}
	
	public String getBookAuthor() throws Exception {
		System.out.println("Enter the Book Author Name: ");
		 String bookAuthor = bufferedReader.readLine();
		 return (bookAuthor.equals(""))?getBookAuthor() : bookAuthor; 
	}
	
	public String getBookSamplePages() throws NumberFormatException {
		int bookSamplePages = 0;
		try {
			System.out.println("Enter the Book Sample Pages: ");
			bookSamplePages = Integer.parseInt(bufferedReader.readLine());
		} catch(Exception e) {
			System.out.println("Enter the correct input");
		}
		return (bookSamplePages != 0) ? bookSamplePages+"" : getBookSamplePages();
	}
	
	public String getBookTotalPages() throws NumberFormatException {
		int totalPages = 0;
		try {
			System.out.println("Enter the Book Total Pages: ");
			totalPages = Integer.parseInt(bufferedReader.readLine());
		} catch(Exception e) {
			System.out.println("Enter the correct input");
		}
		return  (totalPages != 0) ? totalPages+"" :getBookTotalPages();
	}
	
	public String getBookId() throws Exception {
		System.out.println("Enter the Book Id");
		String bookId = bufferedReader.readLine();
		return (bookId.equals("")) ? getBookId() : bookId;
	}
	
	public String getUserName() throws Exception {
		System.out.println("Enter the User Name: ");
		String userName = bufferedReader.readLine();
		return (userName.equals(""))? getUserName() : userName;
	}
	
	public String getFirstName() throws Exception {
		System.out.println("Enter the First Name: ");
		String firstName = bufferedReader.readLine();
		return (firstName.equals("")) ? getFirstName() : firstName;
	}
	
	public String getLastName() throws Exception {
		System.out.println("Enter the Last Name: ");
		String lastName = bufferedReader.readLine();
		return (lastName.equals("")) ? getLastName() : lastName;
	}
	
}
