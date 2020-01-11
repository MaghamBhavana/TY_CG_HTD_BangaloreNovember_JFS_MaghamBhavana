package com.capgemini.module2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.module2.dto.OrderInfoBean;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	
	@Override
	public boolean addOrder(OrderInfoBean orderBean) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(orderBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<OrderInfoBean> getAllOrders() {
		EntityManager manager = entityManagerFactory.createEntityManager();
		String getall = "from OrderInfoBean";
		TypedQuery<OrderInfoBean> query = manager.createQuery(getall, OrderInfoBean.class);
		return query.getResultList();
	}

	@Override
	public OrderInfoBean searchOrder(int id) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		OrderInfoBean order = manager.find(OrderInfoBean.class, id);
		return order;
	}

}
