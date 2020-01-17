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

import com.capgemini.forestmanagement.dto.UserBean;
import com.capgemini.forestmanagement.exception.DataBaseNotFoundException;
import com.capgemini.forestmanagement.exception.FileNotFoundException;

public class UserDAOImpl implements UserDAO {

	FileReader reader;
	Properties prop;
	UserBean user;
	List<UserBean> list;

	public UserDAOImpl() {
		try {
			reader = new FileReader("login.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			FileNotFoundException.exception();
		}
	}

	@Override
	public UserBean login(String email, String password, String role) {

		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("Query"))) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			pstmt.setString(3, role);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new UserBean();
				user.setEmail(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setRole(rs.getString(3));
			}
			return user;
		} catch (Exception e) {
			throw new DataBaseNotFoundException();
		}

	}

	@Override
	public boolean addUser(UserBean bean) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insert"))) {
			pstmt.setString(1, bean.getEmail());
			pstmt.setString(2, bean.getPassword());
			pstmt.setString(3, bean.getRole());
			pstmt.setString(4, bean.getName());
			pstmt.setInt(5,bean.getId());
			pstmt.setLong(6, bean.getPhoneNumber());

			int count = pstmt.executeUpdate();

			if (count > 0)
				return true;

		} catch (Exception e) {
			throw new DataBaseNotFoundException();
		}
		return false;
	}

	@Override
	public boolean deleteUser(String email) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("delete"))) {
			pstmt.setString(1, email);

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
	public List<UserBean> getAllUsers() {
		list = new ArrayList<UserBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("getAll"))) {
			while (rs.next()) {
				user = new UserBean();
				user.setEmail(rs.getString(1));
				user.setName(rs.getString(4));
				user.setRole(rs.getString(3));
				user.setId(rs.getInt(5));
				user.setPhoneNumber(rs.getLong(6));

				list.add(user);
				return list;
			}
		} catch (Exception e) {
			throw new DataBaseNotFoundException();
		}
		return null;
	}

}
