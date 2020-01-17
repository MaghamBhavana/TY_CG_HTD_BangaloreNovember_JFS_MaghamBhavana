package com.capgemini.forestmanagentsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagentsystem.dto.HaulierBean;

@Repository
public class HaulierDAOImpl implements HaulierDAO {

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;
	@Override
	public boolean addHauiler(HaulierBean bean) {
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
			System.err.println(e.getMessage());
			entityTransaction.rollback();
		}
		entityManager.close();
		return false;
	
	}

	@Override
	public HaulierBean getHaulier(int haulierId) {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			String jpql="from HaulierBean where haulierId=:haulierId";
			Query query=entityManager.createQuery(jpql);
			query.setParameter("haulierId", haulierId);
			HaulierBean record= (HaulierBean) query.getSingleResult();
			if(record != null) {
				return record;
			} 
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return null;
	}

	@Override
	public List<HaulierBean> getAllHauliers() {
		EntityManager entityManager = null;
		
		try {
		entityManager=entityManagerFactory.createEntityManager();
		String jpql="from HaulierBean";
		TypedQuery<HaulierBean> query = entityManager.createQuery(jpql, HaulierBean.class);
		return query.getResultList();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	@Override
	public boolean updateHaulier(HaulierBean bean) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		HaulierBean haulierBean = entityManager.find(HaulierBean.class, bean.getHaulierId());
		if (haulierBean != null) {
			transaction.begin();
			haulierBean.setHaulierName(bean.getHaulierName());
			haulierBean.setAddress1(bean.getAddress1());
			haulierBean.setAddress2(bean.getAddress2());
			haulierBean.setTown(bean.getTown());
			haulierBean.setPostalCode(bean.getPostalCode());
			haulierBean.setEmail(bean.getEmail());
			haulierBean.setTelephone(bean.getTelephone());
			transaction.commit();
			
			return true;
		}
		entityManager.close();
		return false;
	}


	@Override
	public boolean deleteHaulier(int haulierId) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
		 entityManager = entityManagerFactory.createEntityManager();
		 transaction = entityManager.getTransaction();
		transaction.begin();
		HaulierBean haulierBean = entityManager.find(HaulierBean.class, haulierId);
		entityManager.remove(haulierBean);
		transaction.commit();
		return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}

}
