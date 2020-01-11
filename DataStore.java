package com.clustrex.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataStore {
	
	Map<String, Book> bookStore = new HashMap<String, Book>();
	Map<String, Customer> customerDataStore = new HashMap<String, Customer>();
	Map<String, ArrayList<String>> customerHandBooks = new HashMap<String, ArrayList<String>>();
	ArrayList<String> customerHandBookId = new ArrayList<String>();
	
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
	
	public void takeBookFromCustomer(String userName, Customer customer) {
		customerDataStore.put(userName, customer);
	}
	
	public void existingCustomerTakeBook(String alreadyUser, String bookId) {
		for(Map.Entry<String, ArrayList<String>> i : customerHandBooks.entrySet()) {
			if(i.getKey().equals(alreadyUser)) {
				customerHandBookId.addAll(i.getValue());
				customerHandBookId.add(bookId);
				customerHandBooks.put(alreadyUser, customerHandBookId);
			}
		}
	}
	
	public void newCustomerTakeBook(String newUser, String BookId) {
		customerHandBookId.add(BookId);
		customerHandBooks.put(newUser, customerHandBookId);
	}
	
	public void displayCustomerBooks(String userName) {
		for(Map.Entry<String, ArrayList<String>> i : customerHandBooks.entrySet()) {
			if(i.getKey().equals(userName)) {
				System.out.println(i.getValue());
			}
		}
	}
	
	public void customerBookReturn(String bookId) {
		customerHandBooks.remove(bookId);
	}
}
