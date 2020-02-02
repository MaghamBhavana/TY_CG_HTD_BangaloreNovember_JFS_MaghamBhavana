package com.capgemini.stockmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dao.StockDAO;
import com.capgemini.stockmanagement.dto.Stock;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockDAO dao;

	@Override
	public boolean addStock(Stock stock) {
		return dao.addStock(stock);
	}

	@Override
	public boolean deleteStock(int stockId) {
		return dao.deleteStock(stockId);
	}

	@Override
	public boolean updateStock(int stockId, Stock stock) {
		return dao.updateStock(stockId, stock);
	}

	@Override
	public List<Stock> getAllStocks() {
		return dao.getAllStocks();
	}

	@Override
	public Stock searchStock(int stockId) {
		return dao.searchStock(stockId);
	}
}
