package com.clustrex.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GettingInput {
	
	BufferedReader bufferedReader;
	public GettingInput(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}
 public String getBookId() throws Exception {
	 System.out.println("Enter the Book Id: ");
	 String bookId = bufferedReader.readLine();
	 return bookId;
 }
 public String getBookName() throws Exception {
	 System.out.println("Enter the book name: ");
	 String bookName = bufferedReader.readLine();
	 return bookName;
 }
 public String getBookAuthor() throws Exception {
	 System.out.println("Enter The Author Name: ");
	 String bookAuthor = bufferedReader.readLine();
	 return bookAuthor;
 }
 public int getSamplePageNumber() throws Exception {
	 int sampleContentLength = 0;
	 try {
		 System.out.println("Enter The Sample Page Number: ");
		 sampleContentLength = Integer.parseInt(bufferedReader.readLine()); 
	 } catch(Exception e) {
		 System.out.println("Enter only integer");
	 }
	 if(sampleContentLength > 0) {
		 return sampleContentLength;
	 } else {
		 getSamplePageNumber();
		 return sampleContentLength;
	 }
 }
 public int getFullPageNumber() throws Exception {
	 int fullContentLength = 0;
	 try {
		 System.out.println("Enter The Full Page Number: ");
		 fullContentLength = Integer.parseInt(bufferedReader.readLine()); 
	 } catch(Exception e) {
		 System.out.println("Enter only Integer");
	 }
	 if(fullContentLength > 0) {
		 return fullContentLength;
	 } else {
		 getFullPageNumber();
		 return fullContentLength;
	 }
 }
 public String sampleContentPage(String samplePageContent , int sampleContentLength) {
		String content = "";
		for(int i = 0; i < sampleContentLength; i++) {
			int value = (int)(samplePageContent.length() * Math.random());
			content+= (samplePageContent.charAt(value));
		}
		return content;
	}
 public void isUser() throws IOException {
		int loopCount = 0;
		do {
			System.out.println("Enter The UserName: ");
			String userName = bufferedReader.readLine();
				if((DataStore.customerDetails.containsKey(userName))) {
					System.out.println("The User Already Here Change it");
				} else {
					System.out.println("Enter the first name: ");
					String firstName = (bufferedReader.readLine());
					System.out.println("Enter the last name: ");
					String lastName = (bufferedReader.readLine());
					Map<String,String> customerValues = new HashMap<String,String>();
					customerValues.put("firstName",firstName);
					customerValues.put("lastname", lastName);
					DataStore.customerDetails.put(userName, customerValues);
					loopCount = 1;
					break;
				}
		} while(loopCount == 0);
	}
 public String getUserName() throws Exception {
	 System.out.println("Enter the UserName: ");
	 String userName = bufferedReader.readLine();
	 return userName;
 }
 public String getChoice() throws Exception {
	 String choice = bufferedReader.readLine();
	 return choice;
 }
}
