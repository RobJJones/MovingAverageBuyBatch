package com.tradeapp.movingAverageBuy;

import com.tradeapp.movingAverageBuy.model.MovingAverageAlert;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.*;
import java.util.*;

public class AlertItemProcessor implements ItemProcessor<MovingAverageAlert, MovingAverageAlert> {

    @Autowired
    private MongoOperations template;

    @Autowired
    private MongoTemplate template1;

    @Value("${stockscraper.downloads.project.directory}")
    private String stockScraperProjectDirectory;

    @Override
    public MovingAverageAlert process(MovingAverageAlert movingAverageAlert) throws Exception {

        createCypressAlert(movingAverageAlert);
        System.out.println(movingAverageAlert);

        return movingAverageAlert;
    }

    private void createCypressAlert(MovingAverageAlert alert) throws InterruptedException, IOException {

        final List<String> command = getCypressCommand(alert);
        ProcessBuilder processBuilder = new ProcessBuilder().inheritIO();
        processBuilder.command(command);
        processBuilder.directory(new File(stockScraperProjectDirectory));
        processBuilder.start().waitFor();
    }

    private List<String> getCypressCommand(MovingAverageAlert alert) {

        List<String> command = new LinkedList<>();
        command.add("/Users/robjones/.nvm/versions/node/v17.1.0/bin/npx");
        command.add("cypress");
        command.add("run");
        command.add("--project");
        command.add(stockScraperProjectDirectory);
        command.add("--spec");
        command.add(stockScraperProjectDirectory+"/"+
                "cypress/integration/stock_data_import/AIM100/tradingViewAIM100_MA_Create_Buy_Alert.spec.js");
        command.add("--browser");
        command.add("chrome");
        command.add("--env");
        command.add("ticker=\""+alert.getTicker()+"\"," +
                "movingAverage=\""+alert.getMovingAverage()+"\","+
                "maSource=\""+alert.getSource()+"\","+
                "stopLoss=\""+alert.getStopLoss()+"\","+
                "takeProfit=\""+alert.getTakeProfit()+"\","+
                "movingAverageShortPeriod=\""+alert.getMovingAverageShortPeriod()+"\","+
                "movingAverageLongPeriod=\""+alert.getMovingAverageLongPeriod()+"\","+
                "barsInAverageTrade=\""+alert.getAverageBarsInTrade()+"\","+
                "percentProfitable=\""+alert.getPercentProfitable()+"\","+
                "averageDailyTradePercent=\""+alert.getAveragePercentagePerDay()+"\","+
                "averageTradePercent=\""+alert.getAverageTrade()+"\","+
                "profitFactor=\""+alert.getProfitFactor()+"\","+
                "maxDrawdown=\""+alert.getMaxDrawdown()+"\","+
                "closedTrades=\""+alert.getClosedTrades()+"\","+
                "riskRewardGains=\""+alert.getRiskRewardGains()+"\","+
                "vwapOn=\""+alert.isVwapOn()+"\","+
                "vwapSource=\""+alert.getVwapSource()+"\""
                );
        return command;
    }
}
