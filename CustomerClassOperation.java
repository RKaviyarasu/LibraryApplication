package com.clustrex.application;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CustomerClassOperation {
	BufferedReader bufferedReader;
	public CustomerClassOperation(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}
	static Map<String,Map<String , String>> customerDetails = new HashMap<String, Map<String , String>>();
	public void takeBook(String customerName, String customerBookSelect) {
		Map<String,String> details = new HashMap<String , String>();
		ArrayList<String> bookData = new ArrayList<String>();
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH,30);
		String dueDate = simpleDateFormat.format(calendar.getTime());
		details.put("customerBookSelect", customerBookSelect);
		details.put("date", dueDate);
		customerDetails.put(customerName, details);
		Set<Map.Entry<String, ArrayList<String>>> dataSet = Main.customerBookDetails.entrySet();
		if(Main.customerBookDetails.containsKey(customerName)) {
			for(Map.Entry<String, ArrayList<String>> i : dataSet) {
				if(i.getKey().equals(customerName)) {
					bookData.addAll(i.getValue());
					bookData.add(customerBookSelect);
					Main.customerBookDetails.put(customerName, bookData);
					break;
				} 
			}
		} else {
			bookData.add(customerBookSelect);
			Main.customerBookDetails.put(customerName, bookData);
		}
		System.out.println("You are taking the book: " + " " + "Book Id: " + " " + customerBookSelect + " " + "DueDate: " + dueDate);
	}
	public void bookReturn(String customerName, String dueDate) throws IOException {
		boolean check = customerDetails.containsKey(customerName);
		dueDate = CustomerClassOperation.customerDetails.get(customerName).get("date");
		if(check == true) {
			SimpleDateFormat sampleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Calendar calendar = Calendar.getInstance();
			String currentDate = sampleDateFormat.format(calendar.getTime()).toString();
			try {
				if(!(dueDate.isEmpty())) {
					System.out.println(CustomerClassOperation.customerDetails.size());
					int compareDate = dueDate.compareTo(currentDate);
					if(compareDate > 0) {
						System.out.println("You have to pay amount because of your duedate is expired!");
					} else {
							Set<Entry<String, ArrayList<String>>> books = Main.customerBookDetails.entrySet();
							for(Entry<String, ArrayList<String>> i : books) {
								if(i.getKey().equals(customerName)) {
									System.out.println(i.getValue());
								}
							}
							System.out.println("Enter the book Id to return: ");
							String returnBookName = bufferedReader.readLine();
							int id = 0;
							Set<Entry<String, ArrayList<String>>> booksData = Main.customerBookDetails.entrySet();
							for(Entry<String, ArrayList<String>> i : booksData) {
								if(i.getKey().equals(customerName)) {
									if(i.getValue().contains((returnBookName))) {
										Main.customerBookDetails.get(customerName).remove(returnBookName);
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
	public void sampleContent() throws IOException { 
		Set<Map.Entry< String, Map< String, String >>> readData = Main.map.entrySet();
		System.out.println("Enter the Book Id: ");
		String bookid = bufferedReader.readLine();
		if(Main.map.containsKey(bookid)){
			for(Map.Entry< String, Map< String, String>> i : readData) {
				if(i.getKey().equals(bookid)) {
					System.out.println("sample content: " + i.getValue().get("samplePage"));
				}
			}
		} else {
			System.out.println("Invalid bookId");
		}
	}
}