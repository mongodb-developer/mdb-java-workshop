package com.mongodb.quickstart.services;

import com.mongodb.quickstart.dtos.DistinctCustomersCountDTO;
import com.mongodb.quickstart.repositories.SalesCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("countDistinctCustomers")
public class CountDistinctCustomersService implements Runnable {

    @Autowired
    private SalesCustomRepository salesCustomRepository;

    @Override
    public void run() {
        List<DistinctCustomersCountDTO> results = salesCustomRepository.countDistinctCustomersByLocation();
        results.forEach(System.out::println);
    }
}
