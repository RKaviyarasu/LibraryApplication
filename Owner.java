package com.clustrex.application;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Owner {
	static Map<String,Map<String , String>> customerDetails = new HashMap<String, Map<String , String>>();
	Map< String,Map< String, String >> map = new HashMap< String,Map< String, String>>();
	public Map<String,String> insertBooks(String bookId, String bookName, String bookAuthor, String samplePageNumber, String fullPage, String samplePage) {
		Map<String,String> valueMap = new HashMap<String,String>();
		valueMap.put("bookName", bookName);
		valueMap.put("Author", bookAuthor);
		valueMap.put("samplePageNumber", samplePageNumber);
		valueMap.put("fullPageNumber", fullPage);
		valueMap.put("samplePage", samplePage);
		return (valueMap);
	}
	public boolean deleteBook(String bookId) {
		if(DataStore.map.containsKey(bookId) == true) {
			map.remove(bookId);
			System.out.println("Deleted Successfully");
			return true;
		} else {
			System.out.println("Book is Not Here");
			return false;
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
	
}