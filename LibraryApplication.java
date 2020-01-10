package com.clustrex.application;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LibraryApplication {
	
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	GettingInput gettingInput = new GettingInput(bufferedReader);
	public void getMenu() {
		String exitChoice = "0";
		do {
			System.out.println("Menu \n 1. Owner \n 2. Customer");
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
			System.out.println("Press 1 to continue...");
			exitChoice = gettingInput.getExitChoice();
		}while(exitChoice.equals("1"));
	}

	public static void main(String[] args) {
		LibraryApplication libraryApplication = new LibraryApplication();
		libraryApplication.getMenu();
	}

}
