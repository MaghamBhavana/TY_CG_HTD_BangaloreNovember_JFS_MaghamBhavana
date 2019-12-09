package com.caps.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteUser 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		try 
		{
			//Load the Driver
//			Driver driver = new com.mysql.jdbc.Driver();
//			DriverManager.registerDriver(driver);
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded-------");

			//Get the DB connection via Driver
			String dbUrl = "jdbc:mysql://127.0.0.1:3306/ty_cg_nov6";
			System.out.println("Enter the Username and the password");
			String user = sc.nextLine();
			String password = sc.nextLine();
			conn = DriverManager.getConnection(dbUrl,user,password);
			System.out.println("Connection established-------");

			//Issue the SQL Query via connection
			String query ="DELETE FROM users_info where userid=? AND password=?";
			pstmt = conn.prepareStatement(query);
			System.out.println("enter the userId----");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			System.out.println("enter the password-----");
			pstmt.setString(2, sc.nextLine());



			int count = pstmt.executeUpdate();
			System.out.println("Query issued");

			//Process the results returned by SQL Query
			if(count > 0)
			{
				System.out.println("User Deleted.....");
			}
			else
			{
				System.err.println("Something went wrong-----");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			//Close all the JDBC Objects
			try 
			{
				if(pstmt != null)
				pstmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				if(conn != null)
				conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			sc.close();

		}

	}

}
