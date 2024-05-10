package com.mongodb.quickstart.dtos;

public record DistinctCustomersCountDTO(String _id, int count) {
    public DistinctCustomersCountDTO(String _id, int count) {
        this._id = _id;
        this.count = count;
    }
}
