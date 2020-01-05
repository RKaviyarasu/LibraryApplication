package com.clustrex.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Main {
	Library library = new Library();
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	static Map< String,Map< String, String >> map = new HashMap< String,Map< String, String>>();
	static Map<String,ArrayList<String>> customerBookDetails = new HashMap<String,ArrayList<String>>();
	OwnerClassOperation ownerClassOperation = new OwnerClassOperation();
	CustomerClassOperation customerClassOpration = new CustomerClassOperation(bufferedReader);
	public void input() throws Exception {
		do {
			System.out.println("\n" + "1.owner"
			+ "\n" + "2.customer");
			System.out.println("Entering you are: ");
			library.setChoiceOperation(bufferedReader.readLine());
			switch(library.getChoiceOperation()) {
			case "1":
				owner();
				break;
			case "2":
				customer();
				break;
			default:
				System.out.println("Invalid Choice!!!!");	
			}
			System.out.println("\n" + "Press 1 to move on Main menu");
			library.setExitChoice(bufferedReader.readLine());
			} while(library.getExitChoice().equals("1"));
		System.out.println("You are Exit!!!");
	}
	public void owner() throws IOException {
		do {
			System.out.println("\n"+ "1.Add Books"
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
				String samplePageContent = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcefghijklmnopqrstuvwxyz";
				String samplePage = ownerClassOperation.sampleContentPage(samplePageContent, library.getSampleContentLength());
				ownerClassOperation.add(library.getBookId(), library.getBookName(), library.getBookAuthor(), (library.getSampleContentLength()+""), (library.getFullContentLength()+"") , samplePage);
				break;
			case "2":
				ownerClassOperation.read();
				System.out.println("Enter the Book ID: ");
				library.setBookId(bufferedReader.readLine());
				if(Main.map.containsKey(library.getBookId())) {
					System.out.println(Main.map.get(library.getBookId()).get("bookName") + " " + Main.map.get(library.getBookId()).get("Author")
							+ " " + Main.map.get(library.getBookId()).get("samplePageNumber")
							+ " " +Main.map.get(library.getBookId()).get("fullPageNumber"));
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
				ownerClassOperation.update(library.getBookId(), library.getUpdateChoice(), library.getUpdateChoiceValue());
				break;
			case "3":
				ownerClassOperation.read();
				System.out.println("Enter The Book Id");
				library.setBookId(bufferedReader.readLine());
				ownerClassOperation.delete(library.getBookId());
				break;
			case "4":
				ownerClassOperation.read();
				break;
			case "5":
				int loopCount = 0;
				do {
					System.out.println("Enter The UserName: ");
					library.setUserName(bufferedReader.readLine());
						if((CustomerClassOperation.customerDetails.containsKey(library.getUserName()))) {
							System.out.println("The User Already Here Change it");
						} else {
							System.out.println("Enter the first name: ");
							library.setFirstName(bufferedReader.readLine());
							System.out.println("Enter the last name: ");
							library.setLastName(bufferedReader.readLine());
							Map<String,String> customerValues = new HashMap<String,String>();
							customerValues.put("firstName",library.getFirstName());
							customerValues.put("lastname", library.getLastName());
							CustomerClassOperation.customerDetails.put(library.getUserName(), customerValues);
							loopCount = 1;
							break;
						}
				} while(loopCount == 0);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("\n" + "press 1 to continue otherwise you are exit from Owner Operation!!!: ");
			library.setChoiceOperation(bufferedReader.readLine());
		}while(library.getChoiceOperation().equals("1"));
	}
	public void customer() throws Exception {
		int loopCount = 0;
		do {
			System.out.println("Enter the UserName: ");
			library.setUserName(bufferedReader.readLine());
			if((CustomerClassOperation.customerDetails.containsKey(library.getUserName()))) {
				loopCount = 1;
				do {
					System.out.println("\n"+ "1. Taking a Book"
							+ "\n" + "2. Returning a Book"
							+ "\n" + "3. Sample Content");
					library.setChoiceOperation(bufferedReader.readLine());
					switch(library.getChoiceOperation()) {
					case "1":
						ownerClassOperation.read();
						System.out.println("The Books are: ");
						System.out.println("Enter the Book Id: ");
						library.setBookId(bufferedReader.readLine());
						if(Main.map.containsKey(library.getBookId())) {
							customerClassOpration.takeBook(library.getUserName(), library.getBookId());
						}
						else {
							System.out.println("Enter the correct book Id");
						}
						break;
					case "2":
						String dueDate = "";
						customerClassOpration.bookReturn(library.getUserName(), dueDate);
						break;
					case "3":
						ownerClassOperation.read();
						customerClassOpration.sampleContent();
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
					owner();
				case "2":
					System.out.println("you are Exit!!");
				}
			}

		}while(loopCount == 0);
    }
	public static void main(String[] args) throws Exception {
		Main choose = new Main();
		choose.input();

	}

}