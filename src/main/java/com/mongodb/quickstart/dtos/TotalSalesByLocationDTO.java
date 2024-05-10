package com.mongodb.quickstart.dtos;

public record TotalSalesByLocationDTO(String _id, int totalSales) {
    public TotalSalesByLocationDTO(String _id, int totalSales) {
        this._id = _id;
        this.totalSales = totalSales;
    }
}
