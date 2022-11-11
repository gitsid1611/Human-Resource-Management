package com.masai.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {
	public static void main(String[] args) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not load the Driver main class");
		}
		

		String url = "jdbc:mysql://localhost:3306/hrms";
		
		try {
			Connection conn=  DriverManager.getConnection(url,"root","Sn_rocking777");
			
			if(conn != null)
				System.out.println("connected...");
			else
				System.out.println("not connected..");
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
  }


