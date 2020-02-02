package com.capgemini.stockmanagement.service;

import com.capgemini.stockmanagement.dto.InvestorRequestObject;

public interface InvestorService {

	boolean addShare(InvestorRequestObject investor);

	boolean buyShare(InvestorRequestObject investor);
	boolean sellShare(InvestorRequestObject investor);

	boolean updateStockAvailability(InvestorRequestObject investor, boolean flag);
}
