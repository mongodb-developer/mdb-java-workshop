package com.mongodb.quickstart.dtos;

public record RevenueByLocationDTO(String storeLocation, double totalRevenue) {
    public RevenueByLocationDTO(String storeLocation, double totalRevenue) {
        this.storeLocation = storeLocation;
        this.totalRevenue = totalRevenue;
    }
}
