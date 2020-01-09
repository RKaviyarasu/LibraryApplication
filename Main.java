package com.clustrex.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main {
	Library library = new Library();
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	Owner ownerClassOperation = new Owner();
	Customer customerClassOpration = new Customer(bufferedReader);
	Map< String,Map< String, String >> map = new HashMap< String,Map< String, String>>();
	/**
	 * This method is used choose the entering user as owner or customer
	 * @throws Exception
	 */
	public void getInput() throws Exception {
		do {
			System.out.println("\n" + "1.owner"
			+ "\n" + "2.customer");
			System.out.println("Entering you are: ");
			library.setChoiceOperation(bufferedReader.readLine());
			switch(library.getChoiceOperation()) {
			case "1":
				isOwner();
				break;
			case "2":
				isCustomer();
				break;
			default:
				System.out.println("Invalid Choice!!!!");	
			}
			System.out.println("\n" + "Press 1 to move on Main menu");
			library.setExitChoice(bufferedReader.readLine());
			} while(library.getExitChoice().equals("1"));
		System.out.println("You are Exit!!!");
	}
	/**
	 * This method is used to owner operation to performed it
	 * @throws IOException
	 */
	public void isOwner() throws IOException {
		do {
			System.out.println("\n" + "1.Add Books"
					+ "\n" + "2.update"
					+ "\n" + "3.delete"
					+ "\n" + "4.Read"
					+ "\n" + "5.addUser"
					+ "\n" + "Enter your Choice: ");
			library.setChoiceOperation(bufferedReader.readLine());
			switch(library.getChoiceOperation()) {
			case "1":
				library.setBookId(UUID.randomUUID().toString());
				System.out.println("Enter the book name: ");
				library.setBookName(bufferedReader.readLine());
				System.out.println("Enter The Author Name: ");
				library.setBookAuthor(bufferedReader.readLine());
				System.out.println("Enter The Sample Page Number: ");
				library.setSampleContentLength(Integer.parseInt(bufferedReader.readLine()));
				System.out.println("Enter the Full Page Number: ");
				library.setFullContentLength(Integer.parseInt(bufferedReader.readLine()));
				library.setSamplePage("ABCDEFGHIJKLMNOPQRSTUVWXYZabcefghijklmnopqrstuvwxyz");
				ownerClassOperation.insertBooks(library.getBookId(), library.getBookName(), library.getBookAuthor(), (library.getSampleContentLength()+""), (library.getFullContentLength()+"") , library.getSamplePage());
				break;
			case "2":
				ownerClassOperation.getBook();
				System.out.println("Enter the Book ID: ");
				library.setBookId(bufferedReader.readLine());
				if(DataStore.map.containsKey(library.getBookId())) {
					System.out.println("Enter You want to change it" + "\n" + "1.bookName" + "\n" + "2.Author"
							+ "\n" + "3.sample Page number" + "\n" + "4.full page number");
					library.setUpdateChoice(bufferedReader.readLine());
					switch(library.getUpdateChoice()) {
					case "1":
						System.out.println("Enter The Book Name to Update: ");
						library.setBookName(bufferedReader.readLine());
						library.setUpdateChoice("bookName");
						library.setUpdateChoiceValue(library.getBookName());
						break;
					case "2":
						System.out.println("Enter the Author Name to Update: ");
						library.setBookAuthor(bufferedReader.readLine());
						library.setUpdateChoice("Author");
						library.setBookAuthor(library.getBookAuthor());
						break;
					case "3":
						System.out.println("Enter The Sample Page Number to Update");
						library.setSampleContentLength(Integer.parseInt(bufferedReader.readLine()));
						library.setUpdateChoice("samplePageNumber");
						library.setUpdateChoiceValue(library.getSampleContentLength()+"");
						break;
					case "4":
						System.out.println("Enter the full Page Number to Update");
						library.setFullContentLength(Integer.parseInt(bufferedReader.readLine()));
						library.setUpdateChoice("fullPageNumber");
						library.setUpdateChoiceValue(library.getFullContentLength()+"");
						break;
						
					default:
						System.out.println("Invalid choice");
						break;
					}
				} else {
					System.out.println("Invalid Id");
				}
				ownerClassOperation.updateBook(library.getBookId(), library.getUpdateChoice(), library.getUpdateChoiceValue());
				break;
			case "3":
				ownerClassOperation.getBook();
				System.out.println("Enter The Book Id");
				library.setBookId(bufferedReader.readLine());
				ownerClassOperation.deleteBook(library.getBookId());
				break;
			case "4":
				ownerClassOperation.getBook();
				break;
			case "5":
				ownerClassOperation.isUser(bufferedReader);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("\n" + "press 1 to continue otherwise you are exit from Owner Operation!!!: ");
			library.setChoiceOperation(bufferedReader.readLine());
		}while(library.getChoiceOperation().equals("1"));
	}
	/**
	 * This method is used to customer operations performed it
	 * @throws Exception
	 */
	public void isCustomer() throws Exception {
		int loopCount = 0;
		do {
			System.out.println("Enter the UserName: ");
			library.setUserName(bufferedReader.readLine());
			if((DataStore.customerDetails.containsKey(library.getUserName()))) {
				loopCount = 1;
				do {
					System.out.println("\n"+ "1. Taking a Book"
							+ "\n" + "2. Returning a Book"
							+ "\n" + "3. Sample Content");
					library.setChoiceOperation(bufferedReader.readLine());
					switch(library.getChoiceOperation()) {
					case "1":
						ownerClassOperation.getBook();
						System.out.println("The Books are: ");
						System.out.println("Enter the Book Id: ");
						library.setBookId(bufferedReader.readLine());
						String pattern = "dd-MM-yyyy";
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
						library.setCalendar(Calendar.getInstance());
						library.getCalendar().add(Calendar.DAY_OF_MONTH,30);
						library.setDueDate(simpleDateFormat.format(library.getCalendar().getTime()));
						if(DataStore.map.containsKey(library.getBookId())) {
							customerClassOpration.takeBook(library.getUserName(), library.getBookId(), library.getDueDate());
						}
						else {
							System.out.println("Enter the correct book Id");
						}
						break;
					case "2":
						SimpleDateFormat sampleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
						library.setCalendar(Calendar.getInstance());
						library.setCurrentDate(sampleDateFormat.format(library.getCalendar().getTime()).toString());
						String dueDate = "";
						customerClassOpration.bookReturn(library.getUserName(), dueDate, library.getCurrentDate());
						break;
					case "3":
						ownerClassOperation.getBook();
						System.out.println("Enter the Book Id: ");
						library.setBookId(bufferedReader.readLine());
						customerClassOpration.sampleContent(library.getBookId());
						break;
					default:
						System.out.println("Invalid Choice");
						break;

					}

					System.out.println("\n" + "Press 1 to continue otherwise you are exit from customer operation");
					library.setExitChoice(bufferedReader.readLine());
				}while(library.getExitChoice().equals("1"));
			} else {
				System.out.println("Invalid userName Contact Owner");
				System.out.println("Do you want to go owner 1.yes 2.No");
				library.setChoiceOperation(bufferedReader.readLine());
				switch(library.getChoiceOperation()) {
				case "1":
					isOwner();
				case "2":
					System.out.println("you are Exit!!");
				}
			}

		}while(loopCount == 0);
    }
	public static void main(String[] args) throws Exception {
		Main choose = new Main();
		choose.getInput();

	}

}
