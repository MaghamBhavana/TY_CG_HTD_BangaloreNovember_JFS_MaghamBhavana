package com.capgemini.stockmanagement.dao;

import com.capgemini.stockmanagement.dto.InvestorRequestObject;

public interface InvestorDAO {

	boolean addShare(InvestorRequestObject investor);


	boolean buyShare(InvestorRequestObject investor);
	boolean sellShare(InvestorRequestObject investor);

	boolean updateStockAvailability(InvestorRequestObject investor, boolean flag);
}
