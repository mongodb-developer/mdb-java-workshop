package com.mongodb.quickstart.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.quickstart.models.Sale;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends MongoRepository<Sale, String>, SalesCustomRepository {
}
