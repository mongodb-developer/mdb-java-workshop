package com.mongodb.quickstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

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
            case "read":
            default:
                context.getBean(Read.class).run();
                break;
        }
    }
}