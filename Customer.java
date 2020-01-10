package com.clustrex.application;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashMap;
import java.io.IOException;
import java.util.ArrayList;

public class Customer {
	GettingInput gettingInput;
	public Customer(GettingInput gettingInput) {
		this.gettingInput = gettingInput;
	}
	
	static Map<String,ArrayList<String>> customerBookDetails = new HashMap<String,ArrayList<String>>();
	public void takeBook(String customerName, String bookId, String dueDate) {
		if(DataStore.customerBookDetails.containsValue(bookId)){
			System.out.println("Already You have Take it in this book");
		} else {
			Map<String,String> details = new HashMap<String , String>();
			ArrayList<String> bookData = new ArrayList<String>();
			details.put("bookId", bookId);
			details.put("date", dueDate);
			DataStore.customerDetails.put(customerName, details);
			Set<Map.Entry<String, ArrayList<String>>> dataSet = DataStore.customerBookDetails.entrySet();
			if(DataStore.customerBookDetails.containsKey(customerName)) {
				for(Map.Entry<String, ArrayList<String>> i : dataSet) {
					if(i.getKey().equals(customerName)) {
						bookData.addAll(i.getValue());
						bookData.add(bookId);
						DataStore.customerBookDetails.put(customerName, bookData);
						break;
					} 
				}
			} else {
				bookData.add(bookId);
				DataStore.customerBookDetails.put(customerName, bookData);
			}
			System.out.println("You are taking the book: " + " " + "Book Id: " + " " + bookId + " " + "DueDate: " + dueDate);
		}
	}
	public void bookReturn(String customerName, String currentDate) throws IOException {
		boolean check = DataStore.customerDetails.containsKey(customerName);
		String dueDate = DataStore.customerDetails.get(customerName).get("date");
		if(check == true) {
			try {
				if(!(dueDate.isEmpty())) {
					System.out.println(DataStore.customerDetails.size());
					int compareDate = dueDate.compareTo(currentDate);
					if(compareDate > 0) {
						System.out.println("You have to pay amount because of your duedate is expired!");
					} else {
							Set<Entry<String, ArrayList<String>>> books = DataStore.customerBookDetails.entrySet();
							for(Entry<String, ArrayList<String>> i : books) {
								if(i.getKey().equals(customerName)) {
									System.out.println(i.getValue());
								}
							}
							String returnBookName = gettingInput.getBookId();
							int id = 0;
							Set<Entry<String, ArrayList<String>>> booksData = DataStore.customerBookDetails.entrySet();
							for(Entry<String, ArrayList<String>> i : booksData) {
								if(i.getKey().equals(customerName)) {
									if(i.getValue().contains((returnBookName))) {
										DataStore.customerBookDetails.get(customerName).remove(returnBookName);
										id = 1;
										break;
									}
								}
							}
							if(id == 0) {
								System.out.println("Enter the correct Id");
							} else {
								System.out.println("Returned Successfully!!!");
							}
								} 
							} else {
							System.out.println("You are not Taking any books so take Book");
							} 
			} catch(Exception e) {
				System.out.println("You are not Taking any books so take Book");
			}
		}else {
			System.out.println("Invalid Customer Id");
			}				
	}
	public void sampleContent(String bookId)  { 
		Set<Map.Entry< String, Map< String, String >>> readData = DataStore.map.entrySet();
		if(DataStore.map.containsKey(bookId)){
			for(Map.Entry< String, Map< String, String>> i : readData) {
				if(i.getKey().equals(bookId)) {
					System.out.println("sample content: " + i.getValue().get("samplePage"));
				}
			}
		} else {
			System.out.println("Invalid bookId");
		}
	}
}
