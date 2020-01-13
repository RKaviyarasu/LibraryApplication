package com.clustrex.application;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LibraryApplication {
	
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	GettingInput gettingInput = new GettingInput(bufferedReader);
	DataStore dataStore = new DataStore();
	Owner owner = new Owner(gettingInput, dataStore);
	CustomerProcess customerProcess = new CustomerProcess(gettingInput, dataStore);
	public void getMenu() throws Exception {
		String exitChoice = "0";
		do {
			System.out.println("Menu \n 1. Owner \n 2. Customer \nEnter your Choice: ");
			switch(gettingInput.getUserChoice()) {
			case "1":
				owner();
				break;
			case "2":
				customer();
				break;
			default:
				System.out.println("Invalid Choice");
				break;	
			}
			System.out.println("\nPress 1 to continue otherwise you are Exit from Main Menu");
			exitChoice = gettingInput.getExitChoice();
		}while(exitChoice.equals("1"));
	}
	
	public void owner() throws Exception {
		String exitChoice = "0";
		do {
			System.out.println("Owner Menu \n 1. Insert Book \n 2. Update Book \n 3. Delete Book \n 4. View Books \n 5. Add User "
					+ "\nEnter your Choice: ");
			switch(gettingInput.getUserChoice()) {
			case "1":
				owner.insertBook();
				break;
			case "2":
				owner.updateBook();
				break;
			case "3":
				owner.deleteBook();
				break;
			case "4":
				owner.viewBooks();
				break;
			case "5":
				owner.addUser();
				break;
			default:
				System.out.println("Invalid Choice!!!");
				break;
			}
			System.out.println("\nPress 1 to Continue with owner Process Otherwise Go to Main Menu \nEnter your Choice: ");
			exitChoice = gettingInput.getExitChoice();
		}while(exitChoice.equals("1"));
		System.out.println("Successfully Exited from owner!!! \nEntering into Main Menu: ");
		getMenu();
	}
	
	public void customer() throws Exception {
		String userName = gettingInput.getUserName();
		if(customerProcess.isUser(userName)) {
			String exitChoice = "0";
			do {
				System.out.println("Customer Menu \n 1. Take Book \n 2. Return Book \n 3. Book Sample Page");
				switch(gettingInput.getUserChoice()) {
				case "1":
					customerProcess.takeBook(userName);
					break;
				case "2":
					customerProcess.bookReturn(userName);
					break;
				case "3":
					customerProcess.bookSamplePage();
					break;
				default:
					System.out.println("Invalid Choice!!!");
					break;
				}
				System.out.println("\nPress 1 to Continue otherwise Go to Main Menu \nEnter your Choice: ");
				exitChoice = gettingInput.getUserChoice();
			}while(exitChoice.equals("1"));
		} else {
			System.out.println("Enter the correct User Name!!! contact Owner");
		}
		System.out.println("Successfully Exited from Customer \nEnter into Main Menu");
		getMenu();
	}

	public static void main(String[] args) throws Exception {
		LibraryApplication libraryApplication = new LibraryApplication();
		libraryApplication.getMenu();
	}

}
