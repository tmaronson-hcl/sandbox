package com.hcl.logging;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;

import org.mockito.BDDMockito.Then;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@TestInstance(Lifecycle.PER_CLASS)  // not needed if use @BeforeEach
class PortfolioTest {
	
	private Stock attStock;
	private Stock ibmStock;
	private List<Stock> stocks;

	@InjectMocks  // Mark Portfolio where injection should occur.
	Portfolio portfolio = new Portfolio();
	
	@Mock // Mark StockService as the mock object.
	StockService stockService;
	
	@BeforeAll
	void setUp() throws Exception {
		stocks = new ArrayList<>();
		attStock = new Stock("1", "ATT", 100);
		ibmStock = new Stock("2", "IBM", 200);
		stocks.add(attStock);
		stocks.add(ibmStock);
		portfolio.setStocks(stocks);
		stockService = mock(StockService.class); 
		portfolio.setStockService(stockService);
		
	}

	@AfterAll
	void tearDown() throws Exception {
		stocks = null;
		portfolio = null;
	}
	
	
	@Test
	void testGetPortfolioValue() {
		
		// getPrice(Stock) is method in mocked object StockService
		when(stockService.getPrice(attStock)).thenReturn(100.00);
		when(stockService.getPrice(ibmStock)).thenReturn(200.00);
		assertEquals(50000.00, portfolio.getMarketValue());
	} 
	

}
