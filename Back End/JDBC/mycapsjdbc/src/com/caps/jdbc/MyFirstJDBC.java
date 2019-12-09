package com.caps.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class MyFirstJDBC 
{
	public static void main(String[] args)
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try 
		{
			//Load the driver
			
//			Driver driver = new com.mysql.jdbc.Driver();
//			DriverManager.registerDriver(driver);
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded........");
			
			//Get DB connection via driver
		
			String dbUrl = "jdbc:mysql://localhost:3306/ty_cg_nov6"+"?user=root&password=root";
			conn=DriverManager.getConnection(dbUrl);
			System.out.println("Connection Established...............");
			
			//Issue SQL Query via connection
			
			String query = "SELECT * FROM users_info";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("Query Issued....");
			System.out.println("**********************************");
			
			//Process the result returned by SQL Query
			
			while(rs.next())
			{
				System.out.println("Userid : "+rs.getInt("userid"));
				System.out.println("UserName : "+rs.getString("username"));
				System.out.println("Email : "+rs.getString("email"));
				//System.out.println("Password : "+rs.getShort("password"));
				System.out.println("*************************************");
			}
		} 
		catch (Exception e)
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
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				try
				{
					if(rs != null)
						rs.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				
			
		}
		
	}

}
