package com.capgemini.module1.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.capgemini.module1.dto.Mobile;

public class PhoneAppDAOImpl implements PhoneApp{
	FileReader reader;
	Properties prop;
	Mobile mobile;

	public PhoneAppDAOImpl()
	{
		try 
		{
			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<Mobile> getAllContacts() {

		List<Mobile> list=new ArrayList<Mobile>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("getAll"))){
			while(rs.next())
			{
				mobile = new Mobile();
				mobile.setName(rs.getString(1));
				mobile.setNumber(rs.getInt(2));
				mobile.setGroup(rs.getString(3));
				list.add(mobile);
			}
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Mobile singleContact(String name) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("singleQuery")))
		{
			pstmt.setString(1, name);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				mobile = new Mobile();
				mobile.setName(rs.getString(1));
				mobile.setNumber(rs.getInt(2));
				mobile.setGroup(rs.getString(3));
			}
			return mobile;

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addContact(Mobile user) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("addQuery"))){

			pstmt.setString(1, user.getName());
			pstmt.setLong(2, user.getNumber());
			pstmt.setString(3,user.getGroup());

			int count = pstmt.executeUpdate();

			if(count>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean deleteContact(String name) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("deleteQuery")))
		{
			pstmt.setString(1, name);
			int count = pstmt.executeUpdate();
			if(count>0)
			{
				return true;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean editContact(String name,long number) {
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt=conn.prepareStatement(prop.getProperty("editQuery")))
		{
			pstmt.setLong(1, number);
			pstmt.setString(2, name);
			int count=pstmt.executeUpdate();
			if(count>0)
			{
				return true;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		return false;
	}

}
