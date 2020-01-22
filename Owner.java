package com.clustrex.application;

import java.util.UUID;

public class Owner {
	
	GettingInput gettingInput;
	DataStore dataStore;
	DataBaseConnection db;
	public Owner(GettingInput gettingInput, DataStore dataStore, DataBaseConnection db) {
		this.gettingInput = gettingInput;
		this.dataStore = dataStore;
		this.db = db;
	}
	
	
	
	public void insertBook() throws Exception {
		String bookId = UUID.randomUUID().toString();
		String bookName = gettingInput.getBookName();
		String bookAuthor = gettingInput.getBookAuthor();
		String totalPage = gettingInput.getBookTotalPages();
		Book book = new Book();
		book.setId(bookId);
		book.setName(bookName);
		book.setAuthor(bookAuthor);
		book.setTotalPages(totalPage);
		book.setSamplePages(gettingInput.getBookSamplePages());
		while(Integer.parseInt(book.getTotalPages()) < Integer.parseInt(book.getSamplePages())) {
			System.out.println("total page is less then sample page");
			book.setSamplePages(gettingInput.getBookSamplePages());
		}
		System.out.println("Book Inserted Successfully");
		db.addBooks(book);
	}
	
	public void updateBook() throws Exception {
		if(db.checkEmpty()) {
			db.bookView();
			String bookId = gettingInput.getBookId();
			if(db.checkId(bookId)) {
				updateChoice(bookId);
			} else {
				System.out.println("Enter the correct bookId");
			}
		} else {
			System.out.println("Book is not Here");
		}
	}
	
	public void updateChoice(String bookId) throws Exception {
		do {
			System.out.println("1. Book Name \n2. Book Author \n3. Book Sample Pages \n4. Book Total Pages \nEnter your Choice: ");
			Book updateBook = db.bookData(bookId);
			switch(gettingInput.getUserChoice()) {
			case "1":
				updateBook.setName(gettingInput.getBookName());
				break;
			case "2":
				updateBook.setAuthor(gettingInput.getBookAuthor());
				break;
			case "3":
				updateBook.setSamplePages(gettingInput.getBookSamplePages());
				while(Integer.parseInt(updateBook.getTotalPages()) < Integer.parseInt(updateBook.getSamplePages())) {
					System.out.println("total page is less then sample page");
					updateBook.setSamplePages(gettingInput.getBookSamplePages());
				}
				break;
			case "4":
				updateBook.setTotalPages(gettingInput.getBookTotalPages());
				break;
			default:
				System.out.println("Invalid Choice!!!!");
				break;
			}
			System.out.println("Book Updated Successfully");
			db.updateBook(bookId, updateBook);
			System.out.println("Do you want update this book yes press 1 otherwise you are exit from current opereration");
		} while(gettingInput.getExitChoice().equals("1"));
		
	}
	
	public void deleteBook() throws Exception {
		if(db.checkEmpty()) {
			db.bookView();
			String bookId = gettingInput.getBookId();
			if(db.checkId(bookId)) {
				db.deleteBook(bookId);
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
			System.out.println("User Details added successfully");
			dataStore.addUserDetails(userName,customer);
		} else {
			System.out.println("User Name Already Exist..");
		}
	}
	
	public void viewBooks() {
		if(db.checkEmpty()) {
			db.bookView();
		} else {
			System.out.println("No Books are Here in the Library");
		}
	}
}