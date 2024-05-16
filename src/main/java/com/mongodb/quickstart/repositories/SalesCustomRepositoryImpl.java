package com.mongodb.quickstart.repositories;

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
		GroupOperation groupStage = Aggregation.group("storeLocation").count().as("totalSales");

		Aggregation aggregation = Aggregation.newAggregation(groupStage);

		AggregationResults<TotalSalesByLocationDTO> results = mongoTemplate.aggregate(aggregation, "sales",
				TotalSalesByLocationDTO.class);

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
	    MatchOperation matchStage = Aggregation.match(Criteria.where("customer.satisfaction").gte(1));

	    GroupOperation groupStage = Aggregation.group("storeLocation")
	        .avg("customer.satisfaction").as("averageSatisfaction");

	    ProjectionOperation projectStage = Aggregation.project()
	        .andExpression("_id").as("storeLocation")
	        .andExpression("averageSatisfaction").as("averageSatisfaction");

	    Aggregation aggregation = Aggregation.newAggregation(matchStage, groupStage, projectStage);

	    AggregationResults<CustomerSatisfactionDTO> results = mongoTemplate.aggregate(aggregation, "sales",
	            CustomerSatisfactionDTO.class);
		
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
		UnwindOperation unwindStage = Aggregation.unwind("items");
		GroupOperation groupStage = Aggregation.group("storeLocation").avg("items.price").as("averagePrice");
		
		Aggregation aggregation = Aggregation.newAggregation(unwindStage, groupStage);
		
		AggregationResults<AverageItemPricePerStoreDTO> results = mongoTemplate.aggregate(aggregation, "sales",
				AverageItemPricePerStoreDTO.class);
		
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
		GroupOperation groupStage = Aggregation.group("storeLocation").addToSet("customer").as("uniqueCustomers");
		ProjectionOperation projectStage = Aggregation.project().andExpression("size(uniqueCustomers)").as("count");
		
		Aggregation aggregation = Aggregation.newAggregation(groupStage, projectStage);
		
		AggregationResults<DistinctCustomersCountDTO> results = mongoTemplate.aggregate(aggregation, "sales",
				DistinctCustomersCountDTO.class);
		
		return results.getMappedResults();
	}

	/**
	 * Question 5: Total Sales by Day 
	 * Calculate the total sales grouped by each day of the week and return a result that includes the day's name (or ID) and the
	 * total sales amount.
	 */
	@Override
	public List<SalesByDayOfWeekDTO> totalSalesByDayOfWeek() {
		ProjectionOperation projectStage = Aggregation.project().andExpression("dayOfWeek(saleDate)").as("dayOfWeek");
		GroupOperation groupStage = Aggregation.group("dayOfWeek").count().as("totalSales");
		Aggregation aggregation = Aggregation.newAggregation(projectStage, groupStage);
		
		AggregationResults<SalesByDayOfWeekDTO> results = mongoTemplate.aggregate(aggregation, "sales",
				SalesByDayOfWeekDTO.class);
		
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
	    UnwindOperation unwindStage = Aggregation.unwind("items");
	    
	    ProjectionOperation projectStage = Aggregation.project("storeLocation")
	            .and("items.price").as("price")
	            .and("items.quantity").as("quantity")
	            .andExpression("items.price * items.quantity").as("total");

	    GroupOperation groupStage = Aggregation.group("storeLocation")
	            .sum("total").as("totalRevenue");

	    ProjectionOperation finalProjectStage = Aggregation.project("totalRevenue")
	            .and("_id").as("storeLocation");

	    SortOperation sortStage = Aggregation.sort(Sort.by(Sort.Direction.DESC, "totalRevenue"));

	    Aggregation aggregation = Aggregation.newAggregation(unwindStage, projectStage, groupStage, finalProjectStage, sortStage);

	    AggregationResults<RevenueByLocationDTO> results = mongoTemplate.aggregate(aggregation, "sales", RevenueByLocationDTO.class);

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
		GroupOperation groupStage = Aggregation.group("storeLocation")
				.sum(ConditionalOperators.Cond.newBuilder()
						.when(Criteria.where("couponUsed").is(true))
						.then(1)
						.otherwise(0))
				.as("salesWithCoupons")
				.sum(ConditionalOperators.Cond.newBuilder()
						.when(Criteria.where("couponUsed").is(false))
						.then(1).otherwise(0))
				.as("salesWithoutCoupons");
		
	    ProjectionOperation projectStage = Aggregation.project()
	            .andExpression("_id").as("storeLocation")
	            .andExpression("salesWithCoupons").as("salesWithCoupons")
	            .andExpression("salesWithoutCoupons").as("salesWithoutCoupons");

		Aggregation aggregation = Aggregation.newAggregation(groupStage, projectStage);
		
		AggregationResults<SalesPerformanceDTO> results = mongoTemplate.aggregate(aggregation, "sales",
				SalesPerformanceDTO.class);
		
		return results.getMappedResults();
	}

}
