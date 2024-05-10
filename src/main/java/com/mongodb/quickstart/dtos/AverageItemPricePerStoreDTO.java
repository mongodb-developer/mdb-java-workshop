package com.mongodb.quickstart.dtos;

public record AverageItemPricePerStoreDTO(String _id, double averagePrice) {
    public AverageItemPricePerStoreDTO(String _id, double averagePrice) {
        this._id = _id;
        this.averagePrice = averagePrice;
    }
}
