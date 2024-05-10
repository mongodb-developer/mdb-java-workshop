package com.mongodb.quickstart.services;

import com.mongodb.quickstart.dtos.CustomerSatisfactionDTO;
import com.mongodb.quickstart.repositories.SalesCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("averageCustomerSatisfaction")
public class AverageCustomerSatisfactionService implements Runnable {

    @Autowired
    private SalesCustomRepository salesCustomRepository;

    @Override
    public void run() {
        List<CustomerSatisfactionDTO> results = salesCustomRepository.averageCustomerSatisfactionByLocation();
        results.forEach(System.out::println);
    }
}
