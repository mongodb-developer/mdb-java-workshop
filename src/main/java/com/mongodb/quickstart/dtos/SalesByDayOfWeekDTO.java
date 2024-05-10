package com.mongodb.quickstart.dtos;

public record SalesByDayOfWeekDTO(String _id, int totalSales) {
    public SalesByDayOfWeekDTO(String _id, int totalSales) {
        this._id = _id;
        this.totalSales = totalSales;
    }
}
