package com.mongodb.quickstart.services;

import com.mongodb.quickstart.dtos.AverageItemPricePerStoreDTO;
import com.mongodb.quickstart.repositories.SalesCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("averageItemPricePerStore")
public class AverageItemPricePerStoreService implements Runnable {

    @Autowired
    private SalesCustomRepository salesCustomRepository;

    @Override
    public void run() {
        List<AverageItemPricePerStoreDTO> results = salesCustomRepository.averageItemPricePerStore();
        results.forEach(System.out::println);
    }
}
