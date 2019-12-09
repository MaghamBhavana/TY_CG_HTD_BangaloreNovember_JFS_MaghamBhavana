package com.caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUser 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			//Load the Driver
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			System.out.println("Driver loaded---");
			
			//Get the DB connection via Driver
			String dbUrl = "jdbc:mysql://127.0.0.1:3306/ty_cg_nov6";
			System.out.println("enter the username and password---");
			String user = sc.nextLine();
			String password = sc.nextLine();
			
			conn = DriverManager.getConnection(dbUrl, user, password);
			System.out.println("Connection established----");
			
			//Issue the SQL Query via connection
			String query = "INSERT INTO users_info values(?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			System.out.println("enter the userId----");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			System.out.println("enter the username-----");
			pstmt.setString(2, sc.nextLine());
			System.out.println("enter the email----");
			pstmt.setString(3, sc.nextLine());
			System.out.println("enter the password----");
			pstmt.setString(4, sc.nextLine());
			
			int count = pstmt.executeUpdate();
			System.out.println("Query issued");

			//Process the results returned by SQL Query
			if(count > 0)
			{
				System.out.println("Inserted.....");
			}
			else
			{
				System.err.println("Something went wrong-----");
			}
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn !=null)
					conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			try
			{
				if(pstmt !=null)
					pstmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			sc.close();
		
		}
	}

}
