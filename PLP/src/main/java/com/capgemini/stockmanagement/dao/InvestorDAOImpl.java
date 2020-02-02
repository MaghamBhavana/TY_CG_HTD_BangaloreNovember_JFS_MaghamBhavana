package com.capgemini.stockmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagement.dto.Company;
import com.capgemini.stockmanagement.dto.InvestorRequestObject;
import com.capgemini.stockmanagement.dto.Investor_Share;


@Repository
public class InvestorDAOImpl implements InvestorDAO {
	
	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public boolean addShare(InvestorRequestObject investor) {
		boolean isAdded = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Investor_Share record = new Investor_Share();
		record.setCompanyId(investor.getCompanyId());
		record.setUserId(investor.getUserId());
		record.setAvailableAmount(investor.getTotalAmount());
		record.setTotalSharesBought(investor.getTotalSharesTransacted());
		record.setTotalAmountBought(investor.getTotalAmount());
		record.setAvailableShares(investor.getTotalSharesTransacted());
		record.setTotalSharesSold(0);
		record.setTotalAmountSold(0);
		try {
			transaction.begin();
			manager.persist(record);
			transaction.commit();
			isAdded = true;
			updateStockAvailability(investor, true);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public boolean buyShare(InvestorRequestObject investor) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			Investor_Share bean = manager.find(Investor_Share.class, investor.getUserId());
			if (bean != null) {
				transaction.begin();
				bean.setTotalAmountBought(bean.getTotalAmountBought() + investor.getTotalAmount());
				bean.setTotalSharesBought(bean.getTotalSharesBought() + investor.getTotalSharesTransacted());
				bean.setAvailableAmount(bean.getAvailableAmount() + investor.getTotalAmount());
				bean.setAvailableShares(bean.getAvailableShares() + investor.getTotalSharesTransacted());
				transaction.commit();
				updateStockAvailability(investor, true);
				isUpdated = true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isUpdated;
	}
	public boolean sellShare(InvestorRequestObject investor) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			Investor_Share bean = manager.find(Investor_Share.class, investor.getUserId());
			if (bean != null) {
				transaction.begin();
				bean.setAvailableAmount(bean.getAvailableAmount() - investor.getTotalAmount());
				bean.setAvailableShares(bean.getAvailableShares() - investor.getTotalSharesTransacted());
				bean.setTotalSharesSold(bean.getTotalSharesSold() + investor.getTotalSharesTransacted());
				bean.setTotalAmountSold(bean.getTotalAmountSold() + investor.getTotalAmount());
				transaction.commit();
				updateStockAvailability(investor, false);
				isUpdated = true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isUpdated;
	}

	@Override
	public boolean updateStockAvailability(InvestorRequestObject investor, boolean flag) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			Company bean = manager.find(Company.class, investor.getCompanyId());
			if (bean != null) {
				transaction.begin();
				if(flag) {
					bean.setStockAvailability(bean.getStockAvailability() + investor.getTotalSharesTransacted());					
				} else {
					bean.setStockAvailability(bean.getStockAvailability() - investor.getTotalSharesTransacted());
				}
				transaction.commit();
				isUpdated = true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isUpdated;
	}

}

