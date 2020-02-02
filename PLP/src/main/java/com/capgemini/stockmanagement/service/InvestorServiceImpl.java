package com.capgemini.stockmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dao.InvestorDAO;
import com.capgemini.stockmanagement.dto.InvestorRequestObject;

@Service
public class InvestorServiceImpl implements InvestorService {

	@Autowired
	InvestorDAO dao;

	@Override
	public boolean addShare(InvestorRequestObject investor) {

		return dao.addShare(investor);
	}

	@Override
	public boolean buyShare(InvestorRequestObject investor) {

		return dao.buyShare(investor);
	}
	@Override
	public boolean sellShare(InvestorRequestObject investor) {

		return dao.sellShare(investor);
	}

	@Override
	public boolean updateStockAvailability(InvestorRequestObject investor, boolean flag) {

		return dao.updateStockAvailability(investor, flag);
	}

}
