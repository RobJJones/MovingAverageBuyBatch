package com.tradeapp.movingAverageBuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MABuyBatch {

    public static void main(String[] args) {
        SpringApplication.run(MABuyBatch.class, args);
    }
}
