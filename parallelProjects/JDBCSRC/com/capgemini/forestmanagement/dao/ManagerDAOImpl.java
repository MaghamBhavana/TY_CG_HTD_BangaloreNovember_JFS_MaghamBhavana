package com.capgemini.forestmanagement.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import com.capgemini.forestmanagement.dto.ManagerBean;

public class ManagerDAOImpl implements ManagerDAO {

	FileReader reader;
	Properties prop;
	ManagerBean manager;

	public ManagerDAOImpl() {
		try {
			reader = new FileReader("login.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("File or class not found exception");
		}
	}

	@Override
	public ManagerBean login(String username, String password) {

		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("Query"))) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				manager = new ManagerBean();
				manager.setUsername(rs.getString(1));
				manager.setPassword(rs.getString(2));
			}
			return manager;
		} catch (Exception e) {
			System.err.println("Data Base not found Exception");
		}
		return null;
	}

	@Override
	public boolean add(String username, String password) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insert"))) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);

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

}
