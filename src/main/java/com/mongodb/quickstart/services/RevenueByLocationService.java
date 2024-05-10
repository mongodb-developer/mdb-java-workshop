package com.mongodb.quickstart.services;

import com.mongodb.quickstart.dtos.RevenueByLocationDTO;
import com.mongodb.quickstart.repositories.SalesCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("revenueByLocation")
public class RevenueByLocationService implements Runnable {

    @Autowired
    private SalesCustomRepository salesCustomRepository;

    @Override
    public void run() {
        List<RevenueByLocationDTO> results = salesCustomRepository.calculateTotalRevenueByLocation();
        results.forEach(System.out::println);
    }
}
