package com.mongodb.quickstart.services;

import com.mongodb.quickstart.dtos.SalesByDayOfWeekDTO;
import com.mongodb.quickstart.repositories.SalesCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("totalSalesByDayOfWeek")
public class TotalSalesByDayOfWeekService implements Runnable {

    @Autowired
    private SalesCustomRepository salesCustomRepository;

    @Override
    public void run() {
        List<SalesByDayOfWeekDTO> results = salesCustomRepository.totalSalesByDayOfWeek();
        results.forEach(System.out::println);
    }
}
