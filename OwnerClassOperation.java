package com.clustrex.application;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OwnerClassOperation {

	public void add(String bookId, String bookName, String bookAuthor, String samplePageNumber, String fullPage, String samplePage) {
		Map<String,String> valueMap = new HashMap<String,String>();
		valueMap.put("bookName", bookName);
		valueMap.put("Author", bookAuthor);
		valueMap.put("samplePageNumber", samplePageNumber);
		valueMap.put("fullPageNumber", fullPage);
		valueMap.put("samplePage", samplePage);
		Main.map.put(bookId, valueMap);
	}
	public void update(String bookNumber, String userChoice, String userChoiceValue) {
		Main.map.get(bookNumber).replace(userChoice, userChoiceValue);
		System.out.println("Updated Successfully!!!");
	}
	public void delete(String bookId) {
		if(Main.map.containsKey(bookId) == true) {
			Main.map.remove(bookId);
			System.out.println("Deleted Successfully");
		} else {
			System.out.println("Book is Not Here");
		}
	}
	public void read() {
		System.out.println("The Books are: " + Main.map.size());
		Set<Entry<String, Map<String, String>>> books = Main.map.entrySet();
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
}