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
		if(dataStore.bookStore.size() > 0) {
			dataStore.displayBook();
			CustomerBookDetails customerBookDetails = new CustomerBookDetails();
			String bookId = gettingInput.getBookId();
			if(dataStore.bookStore.containsKey(bookId)) {
				customerBookDetails.setUserName(userName);
				customerBookDetails.setBookId(bookId);
				customerBookDetails.setBookName(dataStore.bookStore.get(bookId).getName());
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_MONTH,30);
				customerBookDetails.setDueDate(simpleDateFormat.format(calendar.getTime()).toString());
				System.out.println("You are taking the book \n book Id: " + customerBookDetails.getBookId() + " Book Name: " + customerBookDetails.getBookName() + " Duedate: " + customerBookDetails.getDueDate());
				//check
				dataStore.takeBook(userName, customerBookDetails);
			} else {
				System.out.println("Enter the correct Book id");
			}
		}else {
			System.out.println("No Books are Here in the Library");
		}
		
	}
	
	public void bookReturn(String userName) throws Exception {
		if(dataStore.customerBookSelect.size() > 0) {
			dataStore.viewCustomerBooks(userName);
			String bookId = gettingInput.getBookId();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Calendar calendar = Calendar.getInstance();
			String currentDate = simpleDateFormat.format(calendar.getTime()).toString();
			//check
			dataStore.customerBookReturn(bookId, userName, currentDate);
		} else {
			System.out.println("You are not Taking any Books");
		}
		
	}
	
	public void bookSamplePage() throws Exception {
		if(dataStore.bookStore.size() > 0) {
			dataStore.displayBook();
			String bookId = gettingInput.getBookId();
			Book book = dataStore.bookStore.get(bookId);
			if(dataStore.bookStore.containsKey(bookId)) {
				sampleContentPage(book);
			} else {
				System.out.println("Enter the correct Book Id");
			}
		}else {
			System.out.println("No books are Here in the Library");
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
