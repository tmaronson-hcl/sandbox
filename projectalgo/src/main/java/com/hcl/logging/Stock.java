package com.hcl.logging;

import java.util.List;

public class Stock {
	private String stockId;
	private String name;
	private int quantity;

	public Stock(String stockId, String name, int quantity) {
		this.stockId = stockId;
		this.name = name;
		this.quantity = quantity;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getTicker() {
		return name;
	}
}

interface StockService {
	public double getPrice(Stock stock);
}

class Portfolio {
	private StockService stockService;
	private List<Stock> stocks;

	public StockService getStockService() {
		return stockService;
	}

	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	/**
	 * @return
	 */
	public double getMarketValue() {
		double marketValue = 0.0;

		marketValue = stocks.stream()
				.mapToDouble(x -> stockService.getPrice(x)*x.getQuantity())
				.sum();
		return marketValue;
		
//		for (Stock stock : stocks) {
//			marketValue += stockService.getPrice(stock) * stock.getQuantity();
//		}
		
	}
}
