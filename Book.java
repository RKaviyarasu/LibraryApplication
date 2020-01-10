package com.clustrex.application;

public class Book {
	
	private String id;
	private String name;
	private String author;
	private String samplePages;
	private String totalPages;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSamplePages() {
		return samplePages;
	}
	public void setSamplePages(String samplePages) {
		this.samplePages = samplePages;
	}
	public String getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}
	
}
