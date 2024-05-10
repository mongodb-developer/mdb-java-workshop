package com.mongodb.quickstart.services;

import com.mongodb.quickstart.dtos.SalesPerformanceDTO;
import com.mongodb.quickstart.repositories.SalesCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("salesPerformance")
public class SalesPerformanceService implements Runnable {

    @Autowired
    private SalesCustomRepository salesCustomRepository;

    @Override
    public void run() {
        List<SalesPerformanceDTO> results = salesCustomRepository.compareSalesWithAndWithoutCoupons();
        results.forEach(System.out::println);
    }
}
