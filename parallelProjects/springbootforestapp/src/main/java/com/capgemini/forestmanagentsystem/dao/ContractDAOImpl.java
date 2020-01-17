package com.capgemini.forestmanagentsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.capgemini.forestmanagentsystem.dto.ContractBean;

@Repository
public class ContractDAOImpl implements ContractDAO {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addContract(ContractBean bean) {

		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(bean);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			e.getMessage();
			entityTransaction.rollback();
		}
		entityManager.close();
		return false;

	}

	@Override
	public ContractBean getContract(int contractNo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ContractBean bean = entityManager.find(ContractBean.class, contractNo);
		return bean;

	}

	@Override
	public List<ContractBean> getAllContracts() {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "from ContractBean";
		TypedQuery<ContractBean> query = entityManager.createQuery(jpql, ContractBean.class);
		return query.getResultList();

	}

	@Override
	public boolean updateContract(ContractBean bean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		ContractBean contractBean = entityManager.find(ContractBean.class, bean.getContractNo());
		if (contractBean != null) {
			transaction.begin();
			contractBean.setCustomerId(bean.getCustomerId());
			contractBean.setProductId(bean.getProductId());
			contractBean.setHaulierId(bean.getHaulierId());
			contractBean.setDeliveryDate(bean.getDeliveryDate());
			contractBean.setDeliveryDay(bean.getDeliveryDay());
			contractBean.setQuantity(bean.getQuantity());
			transaction.commit();
			return true;
		}
		return false;
	}
	

	@Override
	public boolean deleteContract(int contractNo) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		ContractBean contractBean = entityManager.find(ContractBean.class, contractNo);
		if (contractBean != null) {
			transaction.begin();
			entityManager.remove(contractBean);
			transaction.commit();
			return true;
		}
		entityManager.close();
		return false;

	}

}
