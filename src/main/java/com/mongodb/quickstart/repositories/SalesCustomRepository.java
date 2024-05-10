package com.mongodb.quickstart.repositories;

import java.util.List;

import com.mongodb.quickstart.dtos.AverageItemPricePerStoreDTO;
import com.mongodb.quickstart.dtos.CustomerSatisfactionDTO;
import com.mongodb.quickstart.dtos.DistinctCustomersCountDTO;
import com.mongodb.quickstart.dtos.RevenueByLocationDTO;
import com.mongodb.quickstart.dtos.SalesByDayOfWeekDTO;
import com.mongodb.quickstart.dtos.SalesPerformanceDTO;
import com.mongodb.quickstart.dtos.TotalSalesByLocationDTO;

public interface SalesCustomRepository {
    List<TotalSalesByLocationDTO> calculateTotalSalesByLocation();
    List<AverageItemPricePerStoreDTO> averageItemPricePerStore();
    List<DistinctCustomersCountDTO> countDistinctCustomersByLocation();
    List<SalesByDayOfWeekDTO> totalSalesByDayOfWeek();
	List<SalesPerformanceDTO> compareSalesWithAndWithoutCoupons();
	List<RevenueByLocationDTO> calculateTotalRevenueByLocation();
	List<CustomerSatisfactionDTO> averageCustomerSatisfactionByLocation();
}