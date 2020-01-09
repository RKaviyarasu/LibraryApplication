package com.clustrex.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataStore {
	static Map< String,Map< String, String >> map = new HashMap< String,Map< String, String>>();
	static Map<String,ArrayList<String>> customerBookDetails = new HashMap<String,ArrayList<String>>();
	static Map<String,Map<String , String>> customerDetails = new HashMap<String, Map<String , String>>();
}
