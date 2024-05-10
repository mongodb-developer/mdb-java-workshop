package com.mongodb.quickstart.dtos;

public record CustomerSatisfactionDTO(String storeLocation, double averageSatisfaction) {
    public CustomerSatisfactionDTO(String storeLocation, double averageSatisfaction) {
        this.storeLocation = storeLocation;
        this.averageSatisfaction = averageSatisfaction;
    }
}
