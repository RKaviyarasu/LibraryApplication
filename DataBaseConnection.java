package com.clustrex.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Common db  connection - proper open and close


public class DataBaseConnection {
	
	Connection con = null;
	public Connection connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryapplication","root","");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public void addBooks(Book book) {
		try {
			con = this.connection();
			String query = "insert into book(id, name, author, samplepage, totalpage) values (?,?,?,?,?)";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, book.getId());
			statement.setString(2, book.getName());
			statement.setString(3, book.getAuthor());
			statement.setString(4, book.getTotalPages());
			statement.setString(5, book.getSamplePages());
			
			int updatedRecord = statement.executeUpdate();
			System.out.println(updatedRecord);
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void updateBook(String id, Book book) {
		try {
			con = this.connection();
			String query = "update book set name = ?, author = ?, samplepage = ?, totalpage = ? where id = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, book.getName());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getSamplePages());
			statement.setString(4, book.getTotalPages());
			statement.setString(5, book.getId());
			int i = statement.executeUpdate();
			System.out.println(i + "updated");
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void deleteBook(String id) {
		try {
			con = this.connection();
			String query = "delete from book where id=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, id);
			int i = statement.executeUpdate();
			System.out.println(i + " record deleted");
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void bookView() {
		try {
			con = this.connection();
			String query = "select * from book";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				System.out.println("Book Id: " + resultSet.getString(1) + " Book Name: " + resultSet.getString(2) +
						" Author: " + resultSet.getString(3) + " Sample Page: " + resultSet.getString(4) +
						" Total Page: " + resultSet.getString(5));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public boolean checkEmpty() {
		boolean isEmpty = false;
		try {
			con = this.connection();
			String query = "select * from book";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				isEmpty = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return isEmpty;
	}
	
	public boolean checkId(String id) {
		boolean isPresent = false;
		try {
			con = this.connection();
			String query = "select * from book where id ='" + id + "'";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.absolute(1)) {
				isPresent = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return isPresent;
	}
	
	public Book bookData(String bookId) {
		Book book = new Book();
		try {
			con = this.connection();
			String query = "select * from book where id ='" + bookId + "'";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.next()) {
				book.setId(resultSet.getString(1));
				book.setName(resultSet.getString(2));
				book.setAuthor(resultSet.getString(3));
				book.setSamplePages(resultSet.getString(4));
				book.setTotalPages(resultSet.getString(5));
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return book;
	}

}
