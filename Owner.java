package com.clustrex.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public class Owner {
	static Map<String,Map<String , String>> customerDetails = new HashMap<String, Map<String , String>>();
	Map< String,Map< String, String >> map = new HashMap< String,Map< String, String>>();
	public void insertBooks(String bookId, String bookName, String bookAuthor, String samplePageNumber, String fullPage, String samplePage) {
		Map<String,String> valueMap = new HashMap<String,String>();
		valueMap.put("bookName", bookName);
		valueMap.put("Author", bookAuthor);
		valueMap.put("samplePageNumber", samplePageNumber);
		valueMap.put("fullPageNumber", fullPage);
		valueMap.put("samplePage", samplePage);
		DataStore.map.put(bookId, valueMap);
	}
	public void updateBook(String bookNumber, String userChoice, String userChoiceValue) {
		DataStore.map.get(bookNumber).replace(userChoice, userChoiceValue);
		System.out.println("Updated Successfully!!!");
	}
	public void deleteBook(String bookId) {
		if(DataStore.map.containsKey(bookId) == true) {
			DataStore.map.remove(bookId);
			System.out.println("Deleted Successfully");
		} else {
			System.out.println("Book is Not Here");
		}
	}
	public void getBook() {
		System.out.println("The Books are: " + DataStore.map.size());
		Set<Entry<String, Map<String, String>>> books = DataStore.map.entrySet();
		for(Map.Entry<String, Map<String,String>> i : books) {
			System.out.println("Book Id: " + i.getKey() + "\n" + "Book Name: "+i.getValue().get("bookName") + "\n"
					+ "Author: " + i.getValue().get("Author") + "\n"
					+ "Sample Page: " + i.getValue().get("samplePageNumber") + "\n"
					+ "full Page Number: " + i.getValue().get("fullPageNumber"));
			
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
	public void isUser(BufferedReader bufferedReader) throws IOException {
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
}