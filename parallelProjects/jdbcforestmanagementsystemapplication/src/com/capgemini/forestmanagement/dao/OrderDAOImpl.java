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

import com.capgemini.forestmanagement.dto.OrderBean;
import com.capgemini.forestmanagement.exception.DataBaseNotFoundException;
import com.capgemini.forestmanagement.exception.FileNotFoundException;

public class OrderDAOImpl implements OrderDAO {

	FileReader reader;
	Properties prop;
	OrderBean orderBean;
	List<OrderBean> list;

	public OrderDAOImpl() {

		try {
			reader = new FileReader("orderdb.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			FileNotFoundException.exception();
		}

	}

	@Override
	public boolean addOrder(OrderBean orderBean) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertQuery"))) {
			pstmt.setInt(1, orderBean.getOrderNo());
			pstmt.setInt(2, orderBean.getCustomerId());
			pstmt.setInt(3, orderBean.getProductId());
			pstmt.setInt(4, orderBean.getHaulierId());
			pstmt.setInt(5, orderBean.getQuantity());
			pstmt.setString(6, orderBean.getDeliveryDay());
			pstmt.setString(7, orderBean.getDeliveryDate());

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
	public OrderBean getOrder(int orderNo) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("searchQuery"))) {
			pstmt.setInt(1, orderNo);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				orderBean = new OrderBean();
				orderBean.setOrderNo(rs.getInt(1));
				orderBean.setCustomerId(rs.getInt(2));
				orderBean.setProductId(rs.getInt(3));
				orderBean.setHaulierId(rs.getInt(4));
				orderBean.setQuantity(rs.getInt(5));
				orderBean.setDeliveryDay(rs.getString(6));
				orderBean.setDeliveryDate(rs.getString(7));
			}
			return orderBean;
		} catch (Exception e) {
			throw new DataBaseNotFoundException();
		}

	}

	@Override
	public List<OrderBean> getAllOrders() {
		list = new ArrayList<OrderBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("getAll"))) {
			while (rs.next()) {
				orderBean = new OrderBean();
				orderBean.setOrderNo(rs.getInt(1));
				orderBean.setCustomerId(rs.getInt(2));
				orderBean.setProductId(rs.getInt(3));
				orderBean.setHaulierId(rs.getInt(4));
				orderBean.setQuantity(rs.getInt(5));
				orderBean.setDeliveryDay(rs.getString(6));
				orderBean.setDeliveryDate(rs.getString(7));
				list.add(orderBean);
			}
			if (list.isEmpty()) {
				return null;
			} else {
				return list;
			}
		} catch (Exception e) {
			throw new DataBaseNotFoundException();
		}
	}

	@Override
	public boolean updateOrder(int orderNo, OrderBean bean) {

		if (!list.isEmpty()) {

			updateCustomerId(orderNo, bean.getCustomerId());

			updateProductId(orderNo, bean.getProductId());

			updateHaulierId(orderNo, bean.getHaulierId());

			updateDeliveryDate(orderNo, bean.getDeliveryDate());

			updateDeliveryDay(orderNo, bean.getDeliveryDay());

			updateQuantity(orderNo, bean.getQuantity());

			return true;

		} else {
			return false;
		}
	}

	private boolean updateQuantity(int orderNo, int quantity) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("quantityUpdate"))) {
			pstmt.setInt(2, orderNo);
			pstmt.setInt(1, quantity);

			int count = pstmt.executeUpdate();

			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			throw new DataBaseNotFoundException();
		}
		return false;

	}

	private boolean updateDeliveryDay(int orderNo, String deliveryDay) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deliveryDayUpdate"))) {
			pstmt.setInt(2, orderNo);
			pstmt.setString(1, deliveryDay);

			int count = pstmt.executeUpdate();

			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			throw new DataBaseNotFoundException();
		}
		return false;

	}

	private boolean updateDeliveryDate(int orderNo, String deliveryDate) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deliveryDateUpdate"))) {
			pstmt.setInt(2, orderNo);
			pstmt.setString(1, deliveryDate);

			int count = pstmt.executeUpdate();

			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			throw new DataBaseNotFoundException();
		}
		return false;

	}

	private boolean updateHaulierId(int orderNo, int haulierId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("haulierIdUpdate"))) {
			pstmt.setInt(2, orderNo);
			pstmt.setInt(1, haulierId);

			int count = pstmt.executeUpdate();

			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			throw new DataBaseNotFoundException();
		}
		return false;

	}

	private boolean updateProductId(int orderNo, int productId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("productIdUpdate"))) {
			pstmt.setInt(2, orderNo);
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

	private boolean updateCustomerId(int orderNo, int customerId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("customerIdUpdate"))) {
			pstmt.setInt(2, orderNo);
			pstmt.setInt(1, customerId);

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
	public boolean deleteOrder(int orderNo) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteQuery"))) {
			pstmt.setInt(1, orderNo);

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
