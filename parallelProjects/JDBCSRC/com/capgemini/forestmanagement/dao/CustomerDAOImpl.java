package com.capgemini.forestmanagement.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.forestmanagement.dto.CustomerBean;
import com.capgemini.forestmanagement.exception.DataBaseNotFoundException;
import com.capgemini.forestmanagement.exception.FileNotFoundException;

public class CustomerDAOImpl implements CustomerDAO {

	FileReader reader;
	Properties prop;
	CustomerBean customerBean;
	List<CustomerBean> list;

	public CustomerDAOImpl() {

		try {
			reader = new FileReader("customerdb.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			FileNotFoundException.exception("File not found exception");
		}

	}

	@Override
	public boolean addCustomer(CustomerBean customerBean) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertQuery"))) {
			pstmt.setInt(1, customerBean.getCustomerId());
			pstmt.setString(2, customerBean.getCustomerName());
			pstmt.setString(3, customerBean.getStreetAddress1());
			pstmt.setString(4, customerBean.getStreetAddress2());
			pstmt.setString(5, customerBean.getTown());
			pstmt.setInt(6, customerBean.getPostalCode());
			pstmt.setString(7, customerBean.getEmail());
			pstmt.setLong(8, customerBean.getPhoneNumber());

			int count = pstmt.executeUpdate();

			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			DataBaseNotFoundException.exception("Data base not found exception");
		}
		return false;
	}

	@Override
	public CustomerBean getCustomer(int customerId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("searchQuery"))) {
			pstmt.setInt(1, customerId);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				customerBean = new CustomerBean();
				customerBean.setCustomerId(rs.getInt(1));
				customerBean.setCustomerName(rs.getString(2));
				customerBean.setStreetAddress1(rs.getString(3));
				customerBean.setStreetAddress2(rs.getString(4));
				customerBean.setTown(rs.getString(5));
				customerBean.setPostalCode(rs.getInt(6));
				customerBean.setEmail(rs.getString(7));
				customerBean.setPhoneNumber(rs.getLong(8));
			}
			return customerBean;
		} catch (Exception e) {
			DataBaseNotFoundException.exception("Data base not found exception");
		}
		return null;
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		list = new ArrayList<CustomerBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("getAll"))) {
			while (rs.next()) {
				customerBean = new CustomerBean();
				customerBean.setCustomerId(rs.getInt(1));
				customerBean.setCustomerName(rs.getString(2));
				customerBean.setStreetAddress1(rs.getString(3));
				customerBean.setStreetAddress2(rs.getString(4));
				customerBean.setTown(rs.getString(5));
				customerBean.setPostalCode(rs.getInt(6));
				customerBean.setEmail(rs.getString(7));
				customerBean.setPhoneNumber(rs.getLong(8));
				list.add(customerBean);
			}
			if(list.isEmpty()) {
				return null;
			} else {
				return list;
			}
		} catch (Exception e) {
			DataBaseNotFoundException.exception("Data base not found exception");
		}
		return null;
	}

	@Override
	public boolean updateCustomer(int customerId, CustomerBean bean) {
		
		if (!list.isEmpty()) {
		updateCustomerName(customerId, bean.getCustomerName());
		
		updateStreetAddress1(customerId, bean.getStreetAddress1());
		
		updateStreetAddress2(customerId, bean.getStreetAddress2());
		
		updateTown(customerId, bean.getTown());
		
		updatePostalCode(customerId, bean.getPostalCode());
		
		updateEmail(customerId, bean.getEmail());
		
		updatePhoneNumber(customerId, bean.getPhoneNumber());
		return true;
		} else {
		return false;
		}
	}

	private boolean updatePhoneNumber(int customerId, long phoneNumber) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("phoneNoUpdate"))){
			pstmt.setInt(2, customerId);
			pstmt.setLong(1, phoneNumber);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			DataBaseNotFoundException.exception("Data base not found exception");
		}
		return false;
	}

	private boolean updateEmail(int customerId, String email) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("emailUpdate"))){
			pstmt.setInt(2, customerId);
			pstmt.setString(1, email);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			DataBaseNotFoundException.exception("Data base not found exception");
		}
		return false;

	}

	private boolean updatePostalCode(int customerId, int postalCode) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("postalCodeUpdate"))){
			pstmt.setInt(2, customerId);
			pstmt.setInt(1, postalCode);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			DataBaseNotFoundException.exception("Data base not found exception");
		}
		return false;

	}

	private boolean updateTown(int customerId, String town) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("townUpdate"))){
			pstmt.setInt(2, customerId);
			pstmt.setString(1, town);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			DataBaseNotFoundException.exception("Data base not found exception");
		}
		return false;

	}

	private boolean updateStreetAddress2(int customerId, String streetAddress2) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("address2Update"))){
			pstmt.setInt(2, customerId);
			pstmt.setString(1, streetAddress2);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			DataBaseNotFoundException.exception("Data base not found exception");
		}
		return false;

	}

	private boolean updateStreetAddress1(int customerId, String streetAddress1) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("address1Update"))){
			pstmt.setInt(2, customerId);
			pstmt.setString(1, streetAddress1);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			DataBaseNotFoundException.exception("Data base not found exception");
		}
		return false;

	}

	private boolean updateCustomerName(int customerId, String customerName) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("customerNameUpdate"))){
			pstmt.setInt(2, customerId);
			pstmt.setString(1,customerName);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			DataBaseNotFoundException.exception("Data base not found exception");
		}
		return false;

	}

	@Override
	public boolean deleteCustomer(int customerId) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteQuery"))){
			pstmt.setInt(1, customerId);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			DataBaseNotFoundException.exception("Data base not found exception");
		}
		return false;
	}

}
