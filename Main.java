package com.clustrex.application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main {
	Library library = new Library();
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	GettingInput gettingInput = new GettingInput(bufferedReader);
	Owner owner = new Owner();
	Customer customer = new Customer(gettingInput);
	DataStore dataStore = new DataStore();
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
			library.setChoiceOperation(gettingInput.getChoice());
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
			library.setExitChoice(gettingInput.getChoice());
			} while(library.getExitChoice().equals("1"));
		System.out.println("You are Exit!!!");
	}
	/**
	 * This method is used to owner operation to performed it
	 * @throws Exception 
	 */
	public void isOwner() throws Exception {
		do {
			System.out.println("\n" + "1.Add Books"
					+ "\n" + "2.update"
					+ "\n" + "3.delete"
					+ "\n" + "4.Read"
					+ "\n" + "5.addUser"
					+ "\n" + "Enter your Choice: ");
			library.setChoiceOperation(gettingInput.getChoice());
			switch(library.getChoiceOperation()) {
			case "1":
				library.setBookId(UUID.randomUUID().toString());
				library.setBookName(gettingInput.getBookName());
				library.setBookAuthor(gettingInput.getBookAuthor());
				library.setSampleContentLength(gettingInput.getSamplePageNumber());
				library.setFullContentLength(gettingInput.getFullPageNumber());
				String samplePageContent = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcefghijklmnopqrstuvwxyz";
				library.setSamplePage(gettingInput.sampleContentPage(samplePageContent, library.getSampleContentLength()));
				library.setBookDetails(owner.insertBooks(library.getBookId(), library.getBookName(), library.getBookAuthor(), (library.getSampleContentLength()+""), (library.getFullContentLength()+"") , library.getSamplePage()));
				dataStore.insertDetails(library.getBookId(),library.getBookDetails());
				break;
			case "2":
				owner.getBook();
				library.setBookId(gettingInput.getBookId());
				if(DataStore.map.containsKey(library.getBookId())) {
					System.out.println("Enter You want to change it" + "\n" + "1.bookName" + "\n" + "2.Author"
							+ "\n" + "3.sample Page number" + "\n" + "4.full page number");
					library.setUpdateChoice(bufferedReader.readLine());
					switch(library.getUpdateChoice()) {
					case "1":
						library.setBookName(gettingInput.getBookName());
						library.setUpdateChoice("bookName");
						library.setUpdateChoiceValue(library.getBookName());
						break;
					case "2":
						library.setBookAuthor(gettingInput.getBookAuthor());
						library.setUpdateChoice("Author");
						library.setBookAuthor(library.getBookAuthor());
						break;
					case "3":
						library.setSampleContentLength(gettingInput.getSamplePageNumber());
						library.setUpdateChoice("samplePageNumber");
						library.setUpdateChoiceValue(library.getSampleContentLength()+"");
						break;
					case "4":
						library.setFullContentLength(gettingInput.getFullPageNumber());
						library.setUpdateChoice("fullPageNumber");
						library.setUpdateChoiceValue(library.getFullContentLength()+"");
						break;
						
					default:
						System.out.println("Invalid choice");
						break;
					}
					dataStore.updateBook(library.getBookId(), library.getUpdateChoice(), library.getUpdateChoiceValue());
				} else {
					System.out.println("Invalid Id");
				}
				break;
			case "3":
				owner.getBook();
				library.setBookId(gettingInput.getBookId());
				dataStore.deleteDetails(library.getBookId(),owner.deleteBook(library.getBookId()));
				break;
			case "4":
				owner.getBook();
				break;
			case "5":
				gettingInput.isUser();
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("\n" + "press 1 to continue otherwise you are exit from Owner Operation!!!: ");
			library.setChoiceOperation(gettingInput.getChoice());
		}while(library.getChoiceOperation().equals("1"));
	}
	/**
	 * This method is used to customer operations performed it
	 * @throws Exception
	 */
	public void isCustomer() throws Exception {
		int loopCount = 0;
		do {
			library.setUserName(gettingInput.getUserName());
			if((DataStore.customerDetails.containsKey(library.getUserName()))) {
				loopCount = 1;
				do {
					System.out.println("\n"+ "1. Taking a Book"
							+ "\n" + "2. Returning a Book"
							+ "\n" + "3. Sample Content");
					library.setChoiceOperation(bufferedReader.readLine());
					switch(library.getChoiceOperation()) {
					case "1":
						owner.getBook();
						library.setBookId(gettingInput.getBookId());
						String pattern = "dd-MM-yyyy";
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
						library.setCalendar(Calendar.getInstance());
						library.getCalendar().add(Calendar.DAY_OF_MONTH,30);
						library.setDueDate(simpleDateFormat.format(library.getCalendar().getTime()));
						if(DataStore.map.containsKey(library.getBookId())) {
							customer.takeBook(library.getUserName(), library.getBookId(), library.getDueDate());
						}
						else {
							System.out.println("Enter the correct book Id");
						}
						break;
					case "2":
						SimpleDateFormat sampleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
						library.setCalendar(Calendar.getInstance());
						library.setCurrentDate(sampleDateFormat.format(library.getCalendar().getTime()).toString());
						customer.bookReturn(library.getUserName(), library.getCurrentDate());
						break;
					case "3":
						owner.getBook();
						library.setBookId(gettingInput.getBookId());
						customer.sampleContent(library.getBookId());
						break;
					default:
						System.out.println("Invalid Choice");
						break;

					}

					System.out.println("\n" + "Press 1 to continue otherwise you are exit from customer operation");
					library.setExitChoice(gettingInput.getChoice());
				}while(library.getExitChoice().equals("1"));
			} else {
				System.out.println("Invalid userName Contact Owner "
						+ "\n Do you want to go owner 1.yes 2.No");
				library.setChoiceOperation(gettingInput.getChoice());
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