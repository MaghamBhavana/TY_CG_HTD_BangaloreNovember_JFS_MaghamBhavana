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

import com.capgemini.forestmanagement.dto.ProductBean;
import com.capgemini.forestmanagement.exception.DataBaseNotFoundException;
import com.capgemini.forestmanagement.exception.FileNotFoundException;

public class ProductDAOImpl implements ProductDAO {

	FileReader reader;
	Properties prop;
	ProductBean productBean;
	List<ProductBean> list;

	public ProductDAOImpl() {

		try {
			reader = new FileReader("productdb.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			FileNotFoundException.exception();
		}

	}

	@Override
	public boolean addProduct(ProductBean productBean) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertQuery"))) {
			pstmt.setInt(1, productBean.getProductId());
			pstmt.setString(2, productBean.getProductName());

			int count = pstmt.executeUpdate();

			if (count > 0) {
				return true;
			}

			else {
				return false;
			}
		} catch (Exception e) {
			throw new DataBaseNotFoundException();
		}
	}

	@Override
	public ProductBean getProduct(int productId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("searchQuery"))) {
			pstmt.setInt(1, productId);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				productBean = new ProductBean();
				productBean.setProductId(rs.getInt(1));
				productBean.setProductName(rs.getString(2));

			}
			if (list.isEmpty()) {
				return null;
			} else {

				return productBean;
			}
		} catch (Exception e) {
			throw new DataBaseNotFoundException();
		}

	}

	@Override
	public List<ProductBean> getAllProducts() {
		list = new ArrayList<ProductBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("getAll"))) {
			while (rs.next()) {
				productBean = new ProductBean();
				productBean.setProductName(rs.getString(1));

				list.add(productBean);
				return list;
			}
		} catch (Exception e) {
			throw new DataBaseNotFoundException();
		}
		return null;
	}

	@Override
	public boolean updateProduct(int productId, ProductBean bean) {
		if(!list.isEmpty()) {
			updateName(productId, bean.getProductName() );
			updateCost(productId, bean.getCost());
			return true;
		} else {
			return false;
		}
		
	}

	private boolean updateCost(int productId, double cost) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("updateCost"))) {
			pstmt.setDouble(2, cost);
			pstmt.setInt(1, productId);

			int count = pstmt.executeUpdate();

			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			throw new DataBaseNotFoundException();
		}
		return false;
		
	}

	private boolean updateName(int productId, String productName) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("updateName"))) {
			pstmt.setString(2, productName);
			pstmt.setInt(1, productId);

			int count = pstmt.executeUpdate();

			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			throw new DataBaseNotFoundException();
		}
		return false;
		
	}

	@Override
	public boolean deleteProduct(int productId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteQuery"))) {
			pstmt.setInt(1, productId);

			int count = pstmt.executeUpdate();

			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			throw new DataBaseNotFoundException();
		}
		return false;
	}
}
