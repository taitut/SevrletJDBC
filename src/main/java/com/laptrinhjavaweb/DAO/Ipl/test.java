package com.laptrinhjavaweb.DAO.Ipl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.News;

public class test {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/new_servlet";
			String user = "root";
			String password = "1234";
			return DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	public static void createFile(String filePart) {
		try {
		File myObj = new File(filePart);
	      if (myObj.createNewFile()) {
	        System.out.println("File created: " + myObj.getName());
	      } else {
	        System.out.println("File already exists.");
	      }
	      
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      
	      e.printStackTrace();
	     
	    }
	}
	public static void writeFile(String filePart, String text) {
		 try {
		      FileWriter myWriter = new FileWriter(filePart);
		      myWriter.write(text);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public static void main(String[] args) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "{\"title\": \"bai-9\",\"content\": \"hom nay la ngay chan doi\",\"catgoryId\": 1}";

		//JSON from file to Object
	
		createFile("E:\\filename.txt");
		writeFile("E:\\filename.txt", jsonInString);
		//JSON from String to Object
		try {
			
			News news = mapper.readValue(new File("E:\\filename.txt"), News.class);
			System.out.println(news.getContent());
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
	}

}
