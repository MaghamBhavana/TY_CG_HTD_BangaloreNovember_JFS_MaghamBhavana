package com.capgemini.forestmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.forestmanagement.dto.HaulierBean;

public class HaulierDAOImpl implements HaulierDAO {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("project");

	
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
			e.printStackTrace();
			entityTransaction.rollback();
		}
		entityManager.close();
		return false;

	}

	
	public HaulierBean getHaulier(int haulierId) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from HaulierBean where haulierId=:haulierId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("haulierId", haulierId);
			HaulierBean record = (HaulierBean) query.getSingleResult();
			if (record != null) {
				return record;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public List<HaulierBean> getAllHauliers() {
		EntityManager entityManager = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from HaulierBean";
			TypedQuery<HaulierBean> query = entityManager.createQuery(jpql, HaulierBean.class);
			return query.getResultList(); 
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	
	public boolean updateHaulier(int haulierId, HaulierBean bean) {
		EntityManager entityManager =  entityManagerFactory.createEntityManager();
		HaulierBean haulierBean = entityManager.find(HaulierBean.class, bean.getHaulierId());
		if(haulierBean != null) {
		updateHaulierName(haulierId, bean.getHaulierName());
		updateAddress1(haulierId, bean.getAddress1());
		updateAddress2(haulierId, bean.getAddress2());
		updateTown(haulierId, bean.getTown());
		updatePostalCode(haulierId, bean.getPostalCode());
		updateEmail(haulierId, bean.getEmail());
		updatePhoneNumber(haulierId, bean.getTelephone());
		return true;
		} return false;
	}

	private boolean updatePhoneNumber(int haulierId, long telephone) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "update HaulierBean set telephone=:telephone where haulierId=:haulierId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("telephone", telephone);
			query.setParameter("haulierId", haulierId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				return true;
			} 
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;

	}

	private boolean updateEmail(int haulierId, String email) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "update HaulierBean set email=:email where haulierId=:haulierId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
			query.setParameter("haulierId", haulierId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				return true;
			} 
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;

	}

	private boolean updatePostalCode(int haulierId, int postalCode) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "update HaulierBean set postalCode=:postalCode where haulierId=:haulierId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("postalCode", postalCode);
			query.setParameter("haulierId", haulierId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				return true;
			} 
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;

	}

	private boolean updateTown(int haulierId, String town) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "update HaulierBean set town=:town where haulierId=:haulierId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("town", town);
			query.setParameter("haulierId", haulierId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				return true;
			} 
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;

	}

	private boolean updateAddress2(int haulierId, String address2) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "update HaulierBean set address2=:address2 where haulierId=:haulierId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("address2", address2);
			query.setParameter("haulierId", haulierId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				return true;
			} 
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;

	}

	private boolean updateAddress1(int haulierId, String address1) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "update HaulierBean set address1=:address1 where haulierId=:haulierId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("address1", address1);
			query.setParameter("haulierId", haulierId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				return true;
			} 
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;

	}

	private boolean updateHaulierName(int haulierId, String haulierName) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			String jpql = "update HaulierBean set haulierName=:haulierName where haulierId=:haulierId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("haulierName", haulierName);
			query.setParameter("haulierId", haulierId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result > 0) {
				return true;
			} 
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		}
		entityManager.close();
		return false;

	}

	
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
