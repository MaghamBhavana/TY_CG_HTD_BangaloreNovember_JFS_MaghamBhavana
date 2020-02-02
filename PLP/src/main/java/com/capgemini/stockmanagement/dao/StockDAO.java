package com.capgemini.stockmanagement.dao;

import java.util.List;

import com.capgemini.stockmanagement.dto.Stock;

public interface StockDAO {
	boolean addStock(Stock stock);

	boolean deleteStock(int stockId);

	boolean updateStock(int stockId, Stock stock);

	List<Stock> getAllStocks();
	
	Stock searchStock(int stockId);

}
