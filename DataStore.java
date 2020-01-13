package com.clustrex.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataStore {
	
	Map<String, Book> bookStore = new HashMap<String, Book>();
	Map<String, Customer> customerDataStore = new HashMap<String, Customer>();
	Map<String, ArrayList<CustomerBookDetails>> customerBook = new HashMap<String, ArrayList<CustomerBookDetails>>();
	ArrayList<CustomerBookDetails> customerBookSelect;
	
	public void addBookDetails(Book book) {
		bookStore.put(book.getId(),  book);
	}
	
	public void updateBookDetails(String id, Book updateBook) {
		bookStore.put(id, updateBook);
	}
	
	public void deleteBookDetails(String id) {
		bookStore.remove(id);
	}
	
	public void displayBook() {
		for(Map.Entry<String, Book> i : bookStore.entrySet()) {
			System.out.println("Book Id: " + i.getKey() + "\nBook name: " + i.getValue().getName() + 
					"\nBook Author : " + i.getValue().getAuthor() + "\nBook Sample Pages: " + i.getValue().getSamplePages() +
					"\nBook Total Pages: " + i.getValue().getTotalPages());
		}
	}
	
	public void addUserDetails(String userName, Customer customer) {
		customerDataStore.put(userName, customer);
	}
	
	public void takeBook(String userName, CustomerBookDetails customerBookDetails) {
		if(customerBook.containsKey(userName)) {
			customerBookSelect.add(customerBookDetails);
			customerBook.put(userName, customerBookSelect);
		} else {
			customerBookSelect = new ArrayList<CustomerBookDetails>();
			customerBookSelect.add(customerBookDetails);
			customerBook.put(userName, customerBookSelect);
		}
	}
	
	public void viewCustomerBooks(String userName) {
		System.out.print("The Books for you: " + customerBookSelect.size());
		for(Map.Entry<String, ArrayList<CustomerBookDetails>> i : customerBook.entrySet()) {
			if(i.getKey().equals(userName)) {
				for(int j = 0; j < i.getValue().size(); j++) {
					System.out.println("\nUser Name: " + i.getValue().get(j).getUserName() + "\nBook Id: " + i.getValue().get(j).getBookId()
							+ "\nBook Name : " + i.getValue().get(j).getBookName() + "\nDuedate: " + i.getValue().get(j).getDueDate());
				}
			}
		}
	}
	
	public void customerBookReturn(String bookId, String userName, String currentDate) {
		for(Map.Entry<String, ArrayList<CustomerBookDetails>> i : customerBook.entrySet()) {
			if(i.getKey().equals(userName)) {
				for(int j = 0; j < i.getValue().size(); j++) {
					if(i.getValue().get(j).getBookId().equals(bookId)) { 
							if(i.getValue().get(j).getDueDate().compareTo(currentDate) < 0) {
								System.out.println("Book Returned Successfully!!!");
								customerBookSelect.remove(j);
							} else {
								System.out.println("You have To Pay money");
								break;
							}
					}else {
						System.out.println("Enter the Correct Book Id");
					}
				}
			}
		}
	}
}
