package com.clustrex.application;

import java.io.BufferedReader;
import java.io.IOException;

public class GettingInput {
	
	BufferedReader bufferedReader;
	public GettingInput(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}
	
	public String getUserChoice() throws Exception {
		return bufferedReader.readLine();
	}
	
	public String getExitChoice() throws Exception {
		return bufferedReader.readLine();
	}
}
