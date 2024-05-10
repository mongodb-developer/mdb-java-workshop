package com.mongodb.quickstart.services;

import com.mongodb.quickstart.dtos.TotalSalesByLocationDTO;
import com.mongodb.quickstart.repositories.SalesCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("totalSalesByLocation")
public class TotalSalesByLocationService {

    @Autowired
    private SalesCustomRepository salesCustomRepository;

    public void run() {
        List<TotalSalesByLocationDTO> results = salesCustomRepository.calculateTotalSalesByLocation();
        results.forEach(result -> System.out.println(result));
    }
}
