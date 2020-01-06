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


import com.capgemini.forestmanagement.dto.HaulierBean;
import com.capgemini.forestmanagement.exception.FileNotFoundException;

public class HaulierDAOImpl implements HaulierDAO {

	FileReader reader;
	Properties prop;
	HaulierBean haulierBean;
	List<HaulierBean> list;

	public HaulierDAOImpl() {

		try {
			reader = new FileReader("haulierdb.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			FileNotFoundException.exception("File not found exception");
		}

	}

	@Override
	public boolean addHauiler(HaulierBean haulierBean) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertQuery"))) {
			pstmt.setInt(1, haulierBean.getHaulierId());
			pstmt.setString(2, haulierBean.getHaulierName());
			pstmt.setString(3, haulierBean.getAddress1());
			pstmt.setString(4, haulierBean.getAddress2());
			pstmt.setString(5, haulierBean.getTown());
			pstmt.setInt(6, haulierBean.getPostalcode());
			pstmt.setLong(7, haulierBean.getTelephone());
			pstmt.setString(8, haulierBean.getEmail());

			int count = pstmt.executeUpdate();

			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("Data base not found exception");
		}
		return false;
	}

	@Override
	public HaulierBean getHaulier(int haulierId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("searchQuery"))) {
			pstmt.setInt(1, haulierId);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				haulierBean = new HaulierBean();
				haulierBean.setHaulierId(rs.getInt(1));
				haulierBean.setHaulierName(rs.getString(2));
				haulierBean.setAddress1(rs.getString(3));
				haulierBean.setAddress2(rs.getString(4));
				haulierBean.setTown(rs.getString(5));
				haulierBean.setPostalcode(rs.getInt(6));
				haulierBean.setTelephone(rs.getLong(7));
				haulierBean.setEmail(rs.getString(8));
			}
			return haulierBean;
		} catch (Exception e) {
			System.err.println("Data not foud exception");
		}
		return null;
	}

	@Override
	public List<HaulierBean> getAllHauliers() {
		list = new ArrayList<HaulierBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("getAll"))) {
			while (rs.next()) {
				haulierBean = new HaulierBean();
				haulierBean.setHaulierId(rs.getInt(1));
				haulierBean.setHaulierName(rs.getString(2));
				haulierBean.setAddress1(rs.getString(3));
				haulierBean.setAddress2(rs.getString(4));
				haulierBean.setTown(rs.getString(5));
				haulierBean.setPostalcode(rs.getInt(6));
				haulierBean.setTelephone(rs.getLong(7));
				haulierBean.setEmail(rs.getString(8));
				list.add(haulierBean);
			}
			if(list.isEmpty()) {
				return null;
			} else {
				return list;
			}
		} catch (Exception e) {
			System.err.println("Data base not found exception");
		}
		return null;
	}

	@Override
	public boolean updateHaulier(int haulierId, HaulierBean bean) {

		if (!list.isEmpty()) {
		updateHaulierName(haulierId, bean.getHaulierName());
		
		updateStreetAddress1(haulierId, bean.getAddress1());
		
		updateStreetAddress2(haulierId, bean.getAddress2());
		
		updateTown(haulierId, bean.getTown());
		
		updatePostalCode(haulierId, bean.getPostalcode());
		
		updateEmail(haulierId, bean.getEmail());
		
		updatePhoneNumber(haulierId, bean.getTelephone());
		return true;
		} else {
		return false;
		}
	}

	private boolean updatePhoneNumber(int haulierId, long telephone) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("phoneNoUpdate"))){
			pstmt.setInt(2, haulierId);
			pstmt.setLong(1, telephone);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.err.println("Data base not found exception");
		}
		return false;
	}

	private boolean updateEmail(int haulierId, String email) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("emailUpdate"))){
			pstmt.setInt(2, haulierId);
			pstmt.setString(1, email);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.err.println("Data base not found exception");
		}
		return false;
	}

	private boolean updatePostalCode(int haulierId, int postalcode) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("postalCodeUpdate"))){
			pstmt.setInt(2, haulierId);
			pstmt.setInt(1, postalcode);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.err.println("Data base not found exception");
		}
		return false;
		
	}

	private boolean updateTown(int haulierId, String town) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("townUpdate"))){
			pstmt.setInt(2, haulierId);
			pstmt.setString(1, town);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.err.println("Data base not found exception");
		}
		return false;
		
	}

	private boolean updateStreetAddress2(int haulierId, String address2) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("address2Update"))){
			pstmt.setInt(2,haulierId);
			pstmt.setString(1, address2);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.err.println("Data base not found exception");
		}
		return false;
		
	}

	private boolean updateStreetAddress1(int haulierId, String address1) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("address1Update"))){
			pstmt.setInt(2, haulierId);
			pstmt.setString(1, address1);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.err.println("Data base not found exception");
		}
		return false;
		
	}

	private boolean updateHaulierName(int haulierId, String haulierName) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("haulierNameUpdate"))){
			pstmt.setInt(2, haulierId);
			pstmt.setString(1,haulierName);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.err.println("Data base not found exception");
		}
		return false;
	}

	@Override
	public boolean deleteHaulier(int haulierId) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteQuery"))){
			pstmt.setInt(1, haulierId);
			
			int count = pstmt.executeUpdate();
			
			if(count>0)
			{
				return true;
			}
		}
		catch(Exception e)
		{
			System.err.println("Data base not found exception");
		}
		return false;
	}

}
