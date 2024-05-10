package com.mongodb.quickstart.dtos;

public record SalesPerformanceDTO(String storeLocation, int salesWithCoupons, int salesWithoutCoupons) {
    public SalesPerformanceDTO(String storeLocation, int salesWithCoupons, int salesWithoutCoupons) {
        this.storeLocation = storeLocation;
        this.salesWithCoupons = salesWithCoupons;
        this.salesWithoutCoupons = salesWithoutCoupons;
    }
}
