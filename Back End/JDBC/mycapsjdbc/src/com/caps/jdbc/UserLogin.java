package com.caps.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserLogin 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try
		{
			//Load the Driver
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			System.out.println("Driver Loaded........");
			
			//Get the DB connection via Driver
			String dbUrl = "jdbc:mysql://127.0.0.1:3306/ty_cg_nov6";
			
			System.out.println("Enter username and password");
			String dbuser = sc.nextLine();
			String dbpass = sc.nextLine();
			conn=DriverManager.getConnection(dbUrl,dbuser,dbpass);
			System.out.println("connection established");
			
			//Issue the SQL Query via connection
			String query = "SELECT * FROM users_info"+" where userid=? AND password=?";
			pstmt = conn.prepareStatement(query);
			System.out.println("enter the userId----");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			System.out.println("enter the password-----");
			pstmt.setString(2, sc.nextLine());
			rs = pstmt.executeQuery();
			//stmt = conn.createStatement();` 
			//rs = stmt.executeQuery(query);
			System.out.println("Query issued");
			
			//Process the results returned by SQL
			if(rs.next())
			{
				System.out.println("Userid : "+rs.getInt(1));
				System.out.println("UserName : "+rs.getString(2));
				System.out.println("Email : "+rs.getString(3));
				System.out.println("*************************************");
			}
			else
			{
				System.err.println("Something went wrong");
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			//Close all JDBC Objects
			
			try 
			{
				if(conn != null)
				conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				if(stmt != null)
				stmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				if(rs != null)
				rs.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
				
			sc.close();
		}
		
	}

}
