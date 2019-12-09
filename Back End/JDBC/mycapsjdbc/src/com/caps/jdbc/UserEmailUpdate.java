package com.caps.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserEmailUpdate {
	
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt=null;
		try
		{
			//Load the Driver
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Diver is loaded");
			
			//Get the DB connection via Driver
			
			String dbUrl="jdbc:mysql://localhost:3306/ty_cg_nov6";
			System.out.println("Enter the DBUserName and DBPassword");
			String user=sc.nextLine();
			String password = sc.nextLine();
			conn = DriverManager.getConnection(dbUrl,user,password);
			System.out.println("Connection Established");
			
			//Issue the SQL Query via Connection
			
			String query="update users_info set email = ? where userid=? and password=?";
			pstmt=conn.prepareStatement(query);
			System.out.println("Enter the UserId");
			pstmt.setInt(2, Integer.parseInt(sc.nextLine()));
			System.out.println("Enter the password");
			pstmt.setString(3, sc.nextLine());
			System.out.println("Enter the new EmailId");
			pstmt.setString(1, sc.nextLine());
			
			int count=pstmt.executeUpdate();
			System.out.println("Query has been issued");
			
			//Process the Results returned by the query
			
			if(count > 0)
			{
				System.out.println("EmailId updated "+count+" rows effected");
			}
			else
			{
				System.err.println("Something went wrong");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//Close all the JDBC Objects
			
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
