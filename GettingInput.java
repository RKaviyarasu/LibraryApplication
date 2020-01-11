package com.clustrex.application;

import java.io.BufferedReader;
import java.io.IOException;

public class GettingInput {
	
	BufferedReader bufferedReader;
	public GettingInput(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}
	
	public String getUserChoice() throws Exception {
		return bufferedReader.readLine();
	}
	
	public String getExitChoice() throws Exception {
		return bufferedReader.readLine();
	}
	
	public String getBookName() throws Exception {
		System.out.println("Enter the Book Name: ");
		return bufferedReader.readLine();
	}
	
	public String getBookAuthor() throws Exception {
		System.out.println("Enter the Book Author Name: ");
		return bufferedReader.readLine();
	}
	
	public String getBookSamplePages() throws Exception {
		int bookSamplePages = 0;
		try {
			System.out.println("Enter the Book Sample Pages: ");
			bookSamplePages = Integer.parseInt(bufferedReader.readLine());
		} catch(Exception e) {
			System.out.println("Enter the correct sample Pages");
			getBookSamplePages();
		}
		return bookSamplePages + "";
	}
	
	public String getBookTotalPages() {
		int totalPages = 0;
		try {
			System.out.println("Enter the Book Total Pages: ");
			totalPages = Integer.parseInt(bufferedReader.readLine());
		} catch(Exception e) {
			System.out.println("Enter the correct Total Pages");
			getBookTotalPages();
		}
		return totalPages + "";
	}
	
	public String getBookId() throws Exception {
		System.out.println("Enter the Book Id");
		return bufferedReader.readLine();
	}
	
	public String getUserName() throws Exception {
		System.out.println("Enter the User Name: ");
		return bufferedReader.readLine();
	}
	
	public String getFirstName() throws Exception {
		System.out.println("Enter the First Name: ");
		return bufferedReader.readLine();
	}
	
	public String getLastName() throws Exception {
		System.out.println("Enter the Last Name: ");
		return bufferedReader.readLine();
	}
	
}
