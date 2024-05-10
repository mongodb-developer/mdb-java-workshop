package com.mongodb.quickstart.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.quickstart.models.Sale;


public interface SalesRepository extends MongoRepository<Sale, String>, SalesCustomRepository {
}
