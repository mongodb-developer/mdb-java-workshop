package com.mongodb.quickstart.repositories;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.stereotype.Repository;

import com.mongodb.quickstart.dtos.AverageItemPricePerStoreDTO;
import com.mongodb.quickstart.dtos.CustomerSatisfactionDTO;
import com.mongodb.quickstart.dtos.DistinctCustomersCountDTO;
import com.mongodb.quickstart.dtos.RevenueByLocationDTO;
import com.mongodb.quickstart.dtos.SalesByDayOfWeekDTO;
import com.mongodb.quickstart.dtos.SalesPerformanceDTO;
import com.mongodb.quickstart.dtos.TotalSalesByLocationDTO;

import java.util.Collections;
import java.util.List;

@Repository
@Primary
public class SalesCustomRepositoryImpl implements SalesCustomRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * Question 1: Total Sales by Location
	 * 
	 * Calculate the total sales grouped by each location and return a result that
	 * includes the location's name (or ID) and the total sales amount.
	 */
	@Override
	public List<TotalSalesByLocationDTO> calculateTotalSalesByLocation() {
		
		// add your code here and edit the AggregationResults to return your results
		
		AggregationResults<TotalSalesByLocationDTO> results = new AggregationResults<>(Collections.emptyList(), new Document());

		return results.getMappedResults();
	}

	/**
	 * Question 2: Customer Satisfaction by Location
	 * 
	 * Calculate the average customer satisfaction rating for each store location,
	 * based on a 'customer.satisfaction' field in each sale document. Only accept
	 * satisfaction ratings thats are greater than or equal to 1.
	 */
	@Override
	public List<CustomerSatisfactionDTO> averageCustomerSatisfactionByLocation() {

		// add your code here and edit the AggregationResults to return your results
		
	    AggregationResults<CustomerSatisfactionDTO> results = new AggregationResults<>(Collections.emptyList(), new Document());

	    return results.getMappedResults();
	}

	/**
	 * Question 3: Average Price of Items per Store
	 * 
	 * Calculate the average price of items sold per store and return a result that
	 * includes the store's name (or ID) and the average price.
	 */
	@Override
	public List<AverageItemPricePerStoreDTO> averageItemPricePerStore() {
		
		// add your code here and edit the AggregationResults to return your results
		
	    AggregationResults<AverageItemPricePerStoreDTO> results = new AggregationResults<>(Collections.emptyList(), new Document());
		
		return results.getMappedResults();
	}

	/**
	 * Question 4: Number of Distinct Customers
	 * 
	 * Count the number of distinct customers and return a result that includes the
	 * identifier for grouping and the count of customers.
	 */
	@Override
	public List<DistinctCustomersCountDTO> countDistinctCustomersByLocation() {
		
		// add your code here and edit the AggregationResults to return your results
		
	    AggregationResults<DistinctCustomersCountDTO> results = new AggregationResults<>(Collections.emptyList(), new Document());
		
		return results.getMappedResults();
	}

	/**
	 * Question 5: Total Sales by Day 
	 * Calculate the total sales grouped by each day of the week and return a result that includes the day's name (or ID) and the
	 * total sales amount.
	 */
	@Override
	public List<SalesByDayOfWeekDTO> totalSalesByDayOfWeek() {

		// add your code here and edit the AggregationResults to return your results
		
	    AggregationResults<SalesByDayOfWeekDTO> results = new AggregationResults<>(Collections.emptyList(), new Document());
		
		return results.getMappedResults();
	}

	/**
	 * Question 6: Sum of Sales Revenue by Location
	 * 
	 * Calculate the total revenue from sales grouped by each location and return a
	 * result that includes the location's name (or ID) and the total revenue. Sort these from highest to lowest.
	 */
	@Override
	public List<RevenueByLocationDTO> calculateTotalRevenueByLocation() {
	    
		// add your code here and edit the AggregationResults to return your results
		
	    AggregationResults<RevenueByLocationDTO> results = new AggregationResults<>(Collections.emptyList(), new Document());

	    return results.getMappedResults();
	}

	/**
	 * Question 7: Sales Performance Before and After Applying Coupons
	 * 
	 * Compare the number of sales transactions with and without coupons at each
	 * store location and return a detailed breakdown.
	 */
	@Override
	public List<SalesPerformanceDTO> compareSalesWithAndWithoutCoupons() {
		
		// add your code here and edit the AggregationResults to return your results
		
	    AggregationResults<SalesPerformanceDTO> results = new AggregationResults<>(Collections.emptyList(), new Document());
		
		return results.getMappedResults();
	}

}