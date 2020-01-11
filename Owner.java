package com.clustrex.application;

import java.util.UUID;

public class Owner {
	
	GettingInput gettingInput;
	DataStore dataStore;
	
	public Owner(GettingInput gettingInput, DataStore dataStore) {
		this.gettingInput = gettingInput;
		this.dataStore = dataStore;
	}
	
	public void insertBook() throws Exception {
		Book book = new Book();
		book.setId(UUID.randomUUID().toString());
		book.setName(gettingInput.getBookName());
		book.setAuthor(gettingInput.getBookAuthor());
		book.setTotalPages(gettingInput.getBookTotalPages());
		book.setSamplePages(gettingInput.getBookSamplePages());
		while(Integer.parseInt(book.getTotalPages()) < Integer.parseInt(book.getSamplePages())) {
			System.out.println("total page is less then sample page");
			book.setSamplePages(gettingInput.getBookSamplePages());
		}
		System.out.println("Book Inserted Successfully");
		dataStore.addBookDetails(book);
	}
	
	public void updateBook() throws Exception {
		dataStore.displayBook();
		if(dataStore.bookStore.size() > 0) {
			String bookId = gettingInput.getBookId();
			if(dataStore.bookStore.containsKey(bookId)) {
				updateChoice(bookId);
			} else {
				System.out.println("Enter the correct bookId");
			}
		} else {
			System.out.println("Book is not Here");
		}
	}
	
	public void updateChoice(String bookId) throws Exception {
		System.out.println("1. Book Name \n2. Book Author \n3. Book Sample Pages \n4. Book Total Pages \nEnter your Choice: ");
		Book updateBook = dataStore.bookStore.get(bookId);
		switch(gettingInput.getUserChoice()) {
		case "1":
			updateBook.setName(gettingInput.getBookName());
			break;
		case "2":
			updateBook.setAuthor(gettingInput.getBookAuthor());
			break;
		case "3":
			updateBook.setSamplePages(gettingInput.getBookSamplePages());
			break;
		case "4":
			updateBook.setTotalPages(gettingInput.getBookTotalPages());
			break;
		default:
			System.out.println("Invalid Choice!!!!");
			break;
		}
		System.out.println("Book Updated Successfully");
		dataStore.updateBookDetails(bookId, updateBook);
	}
	
	public void deleteBook() throws Exception {
		dataStore.displayBook();
		if(dataStore.bookStore.size() > 0) {
			String bookId = gettingInput.getBookId();
			if(dataStore.bookStore.containsKey(bookId)) {
				dataStore.deleteBookDetails(bookId);
				System.out.println("Book Deleted Successfully");
			} else {
				System.out.println("Enter the correct Book Id");
			}
		} else {
			System.out.println("Book is not Here");
		}
	}
	
	public void addUser() throws Exception {
		Customer customer = new Customer();
		String userName = gettingInput.getUserName();
		if(!dataStore.customerDataStore.containsKey(userName)) {
			String firstName = gettingInput.getFirstName();
			String lastName = gettingInput.getLastName();
			customer.setUserName(userName);
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
		} else {
			System.out.println("User Name Already Exist..");
		}
		System.out.println("User Details added successfully");
		dataStore.addUserDetails(userName,customer);
	}
	
	public void viewBooks() {
		dataStore.displayBook();
	}
}
