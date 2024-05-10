package com.mongodb.quickstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.mongodb.quickstart.services.AverageCustomerSatisfactionService;
import com.mongodb.quickstart.services.AverageItemPricePerStoreService;
import com.mongodb.quickstart.services.CountDistinctCustomersService;
import com.mongodb.quickstart.services.RevenueByLocationService;
import com.mongodb.quickstart.services.SalesPerformanceService;
import com.mongodb.quickstart.services.TotalSalesByDayOfWeekService;
import com.mongodb.quickstart.services.TotalSalesByLocationService;

@SpringBootApplication
@ComponentScan(basePackages = "com.mongodb.quickstart")
public class Application implements CommandLineRunner {
    private static String mode = "read";

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        if (args.length > 0) {
            mode = args[0];
        }
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        switch (mode.toLowerCase()) {
            case "create":
                context.getBean(Create.class).run();
                break;
            case "delete":
                context.getBean(Delete.class).run();
                break;
            case "mapping":
                context.getBean(MappingPOJO.class).run();
                break;
            case "update":
                context.getBean(Update.class).run();
                break;
            case "total-sales-by-location":
                context.getBean(TotalSalesByLocationService.class).run();
                break;
            case "average-customer-satisfaction":
                context.getBean(AverageCustomerSatisfactionService.class).run();
                break;
            case "average-item-price-per-store":
                context.getBean(AverageItemPricePerStoreService.class).run();
                break;
            case "count-distinct-customers":
                context.getBean(CountDistinctCustomersService.class).run();
                break;
            case "total-sales-by-day-of-week":
                context.getBean(TotalSalesByDayOfWeekService.class).run();
                break;
            case "sales-performance":
                context.getBean(SalesPerformanceService.class).run();
                break;
            case "revenue-by-location":
                context.getBean(RevenueByLocationService.class).run();
                break;
            case "read":
            default:
                context.getBean(Read.class).run();
                break;
        }
    }
}