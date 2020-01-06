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

import com.capgemini.forestmanagement.dto.ContractBean;
import com.capgemini.forestmanagement.exception.ContractIdNotFoundExcpection;
import com.capgemini.forestmanagement.exception.DataBaseNotFoundException;
import com.capgemini.forestmanagement.exception.FileNotFoundException;

public class ContractDAOImpl implements ContractDAO {

	FileReader reader;
	Properties prop;
	ContractBean contractBean;
	List<ContractBean> list;

	public ContractDAOImpl() {

		try {
			reader = new FileReader("contractdb.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			FileNotFoundException.exception("File not found exception");
		}

	}

	@Override
	public boolean addContract(ContractBean contractBean) {
		
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertQuery"))) {
			pstmt.setInt(1, contractBean.getContractNo());
			pstmt.setInt(2, contractBean.getCustomerId());
			pstmt.setInt(3, contractBean.getProductId());
			pstmt.setInt(4, contractBean.getHaulierId());
			pstmt.setString(5, contractBean.getDeliveryDate());
			pstmt.setString(6, contractBean.getDeliveryDay());
			pstmt.setInt(7, contractBean.getQuantity());

			int count = pstmt.executeUpdate();

			if (count > 0) {
				return true;
			}

			else {
				return false;
			}
		} catch (Exception e) {
			DataBaseNotFoundException.exception("Data base not found exception");
		}
		return false;
	}

	@Override
	public ContractBean getContract(int contractNo) {
		if(contractNo < 0) {
			throw new ContractIdNotFoundExcpection();
		}
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("searchQuery"))){
			pstmt.setInt(1, contractNo);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				contractBean = new ContractBean();
				contractBean.setContractNo(rs.getInt(1));
				contractBean.setCustomerId(rs.getInt(2));
				contractBean.setProductId(rs.getInt(3));
				contractBean.setHaulierId(rs.getInt(4));
				contractBean.setDeliveryDate(rs.getString(5));
				contractBean.setDeliveryDay(rs.getString(6));
				contractBean.setQuantity(rs.getInt(7));
			}
			return contractBean;
		}
		catch(Exception e)
		{
			DataBaseNotFoundException.exception("Data base not found exception");
		}
		return null;
		
	}

	@Override
	public List<ContractBean> getAllContracts() {
		 list = new ArrayList<ContractBean>();
		try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("getAll"))){
					while(rs.next())
					{
						contractBean = new ContractBean();
						contractBean.setContractNo(rs.getInt(1));
						contractBean.setCustomerId(rs.getInt(2));
						contractBean.setProductId(rs.getInt(3));
						contractBean.setHaulierId(rs.getInt(4));
						contractBean.setDeliveryDate(rs.getString(5));
						contractBean.setDeliveryDay(rs.getString(6));
						contractBean.setQuantity(rs.getInt(7));
						list.add(contractBean);
					}
					if(list.isEmpty()) {
					return null;
					} else {
						return list;
					}
		}
		catch(Exception e)
		{
			DataBaseNotFoundException.exception("Data base not found exception");
		}
		return null;
	}

	@Override
	public boolean updateContract(int contractNo, ContractBean bean) {
		
		if (!list.isEmpty()) {
			
			
			updateCustomerId(contractNo, bean.getCustomerId());
			
			updateProductId(contractNo, bean.getProductId());
			
			updateHaulierId(contractNo, bean.getHaulierId());
			
			updateDeliveryDate(contractNo, bean.getDeliveryDate());
			
			updateDeliveryDay(contractNo, bean.getDeliveryDay());
			
			updateQuantity(contractNo,bean.getQuantity());
			
			
			return true;

		} else {
			return false;
		}
	}

	private boolean updateQuantity(int contractNo, int quantity) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("quantityUpdate"))){
			pstmt.setInt(2, contractNo);
			pstmt.setInt(1, quantity);
			
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

	private boolean updateDeliveryDay(int contractNo, String deliveryDay) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deliveryDayUpdate"))){
			pstmt.setInt(2, contractNo);
			pstmt.setString(1, deliveryDay);
			
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

	private boolean updateDeliveryDate(int contractNo, String deliveryDate) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deliveryDateUpdate"))){
			pstmt.setInt(2, contractNo);
			pstmt.setString(1, deliveryDate);
			
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

	private boolean updateHaulierId(int contractNo, int haulierId) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("haulierIdUpdate"))){
			pstmt.setInt(2, contractNo);
			pstmt.setInt(1, haulierId);
			
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

	private boolean updateProductId(int contractNo, int productId) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("productIdUpdate"))){
			pstmt.setInt(2, contractNo);
			pstmt.setInt(1, productId);
			
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

	private boolean updateCustomerId(int contractNo, int customerId) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("customerIdUpdate"))){
			pstmt.setInt(2, contractNo);
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

	@Override
	public boolean deleteContract(int contractNo) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), 
				prop.getProperty("dbUser"), prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteQuery"))){
			pstmt.setInt(1, contractNo);
			
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
