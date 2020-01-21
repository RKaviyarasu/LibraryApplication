package com.clustrex.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Common db  connection - proper open and close


public class DataBaseConnection {
	
	public Connection connection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryapplication","root","");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public void addBooks(Book book) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryapplication","root","");
			String query = "insert into book(id,name,author,samplepage,totalpage)"+"values (?,?,?,?,?)";
			PreparedStatement statement = this.connection().prepareStatement(query);
			statement.setString(1, book.getId());
			statement.setString(2, book.getName());
			statement.setString(3, book.getAuthor());
			statement.setString(4, book.getTotalPages());
			statement.setString(5, book.getSamplePages());
			
			int updatedRecord = statement.executeUpdate();
			System.out.println(updatedRecord);
			
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
	public void updateBook(String id, Book book) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryapplication","root","");
			String query = "update book set name=?, author=?, samplepage=?, totalpage=? where id=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, book.getId());
			statement.setString(2, book.getName());
			statement.setString(3, book.getAuthor());
			statement.setString(4, book.getSamplePages());
			statement.setString(5, book.getTotalPages());
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
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryapplication","root","");
			String query = "DELETE book WHERE id=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, id);
			statement.executeUpdate();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		

	
	}

}
