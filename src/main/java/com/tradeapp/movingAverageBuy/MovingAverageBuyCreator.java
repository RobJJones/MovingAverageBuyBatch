package com.tradeapp.movingAverageBuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MovingAverageBuyCreator {

    public static void main(String[] args) {
        SpringApplication.run(MovingAverageBuyCreator.class, args);
    }
}
