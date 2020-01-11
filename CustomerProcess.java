package com.clustrex.application;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CustomerProcess {
	
	GettingInput gettingInput;
	DataStore dataStore;
	public CustomerProcess(GettingInput gettingInput, DataStore dataStore) {
		this.gettingInput = gettingInput;
		this.dataStore = dataStore;
	}
	
	public boolean isUser(String userName) {
		if(dataStore.customerDataStore.containsKey(userName)) {
			return true;
		}
		return false;
	}
	
	public void takeBook(String userName) throws Exception {
		dataStore.displayBook();
		Customer customer = new Customer();
		String bookId = gettingInput.getBookId();
		if(dataStore.bookStore.containsKey(bookId)) {
			if(dataStore.customerDataStore.containsValue(bookId)) {
				System.out.println("Already this book is Taken!!");
			} else {
				customer.setUserName(userName);
				customer.setBookId(bookId);
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_MONTH,30);
				customer.setDuedate(simpleDateFormat.format(calendar.getTime()).toString());
				System.out.println("You are taking the book \n book Id: " + customer.getBookId() + "Duedate: " + customer.getDueDate());
			}
		}
		dataStore.takeBookFromCustomer(userName, customer);
		if(dataStore.customerHandBooks.containsKey(userName)) {
			dataStore.existingCustomerTakeBook(userName, customer.getBookId());
		} else {
			dataStore.newCustomerTakeBook(userName, customer.getBookId());
		}
	}
	
	public void bookReturn(String userName) throws Exception {
		Customer customer = new Customer();
		dataStore.displayCustomerBooks(userName);
		String bookId = gettingInput.getBookId();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Calendar calendar = Calendar.getInstance();
		String currentDate = simpleDateFormat.format(calendar.getTime()).toString();
		if(dataStore.customerHandBooks.containsValue(bookId)) {
			if(customer.getDueDate().compareTo(currentDate) > 0) {
				System.out.println("You are Delayed to book return So you have to pay money");
			} else {
				System.out.println("Successfully Book Returned");
				dataStore.customerBookReturn(bookId);
			}
		} else {
			System.out.println("Enter the Correct Book Id");
		}
		
	}
	
	public void bookSamplePage() throws Exception {
		dataStore.displayBook();
		String bookId = gettingInput.getBookId();
		Book book = dataStore.bookStore.get(bookId);
		if(dataStore.bookStore.containsKey(bookId)) {
			sampleContentPage(book);
		} else {
			System.out.println("Enter the correct Book Id");
		}
	}
	
	public void sampleContentPage(Book book) {
		String content = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int samplePages = Integer.parseInt(book.getSamplePages());
		String sampleContent = "";
		for(int i = 0; i < samplePages; i++) {
			int position = (int) (content.length()*Math.random());
			sampleContent+= content.charAt(position);
		}
		System.out.println(sampleContent);
	}
}
