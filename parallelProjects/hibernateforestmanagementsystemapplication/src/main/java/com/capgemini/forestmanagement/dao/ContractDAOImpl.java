package com.capgemini.forestmanagement.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.forestmanagement.dto.ContractBean;
import com.capgemini.forestmanagement.dto.CustomerBean;
import com.capgemini.forestmanagement.dto.HaulierBean;
import com.capgemini.forestmanagement.dto.ProductBean;


public class ContractDAOImpl implements ContractDAO {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("project");

	public boolean addContract(ContractBean bean) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		try {
			entityTransaction.begin();
			entityManager.merge(bean);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			entityTransaction.rollback();
		} finally {
		entityManager.close();
		}
		return false;
	}

	public ContractBean getContract(int contractNo) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			ContractBean bean = entityManager.find(ContractBean.class, contractNo);
			return bean;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	public List<ContractBean> getAllContracts() {
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from ContractBean";
			TypedQuery<ContractBean> query = entityManager.createQuery(jpql, ContractBean.class);
			return query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public boolean updateContract(int contractNo, ContractBean bean) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			ContractBean contractBean = entityManager.find(ContractBean.class, bean.getContractNo());
			if (contractBean != null) {
				transaction.begin();
				if (bean.getCustomer() != null) {
					contractBean.setCustomer(bean.getCustomer());
				}
				contractBean.setDeliveryDate(bean.getDeliveryDate());
				contractBean.setDeliveryDay(bean.getDeliveryDay());
				if (bean.getHaulier() != null) {
					contractBean.setHaulier(bean.getHaulier());
				}
				if (bean.getProduct() != null) {
					contractBean.setProduct(bean.getProduct());
				}
				contractBean.setQuantity(bean.getQuantity());
				entityManager.merge(contractBean);
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			entityManager.close();
		}
		return false;
	}
	
	public boolean deleteContract(int contractNo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			ContractBean contractBean = entityManager.find(ContractBean.class, contractNo);
			entityManager.remove(contractBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			entityManager.close();
		}
		return false;
	}

	@Override
	public CustomerBean getCustomer(int customerId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			CustomerBean cutomerBean = manager.find(CustomerBean.class, customerId);
			return cutomerBean;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public ProductBean getProduct(int productId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			ProductBean productBean = manager.find(ProductBean.class, productId);
			return productBean;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public HaulierBean getHaulier(int haulierId) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			HaulierBean haulierBean = manager.find(HaulierBean.class, haulierId);
			return haulierBean;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			manager.close();
		}
		return null;
	}
}


