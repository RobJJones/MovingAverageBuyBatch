package com.tradeapp.movingAverageBuy.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "view_ma_strategy_30")
public class MovingAverageAlert {

    public String ticker;
    public int movingAverageShortPeriod;
    public int movingAverageLongPeriod;
    public String movingAverage;
    public String source;
    public double averagePercentagePerDay;
    public double profitFactor;
    public int averageBarsInTrade;
    public double averageTrade;
    public double maxDrawdown;
    public double percentProfitable;
    public int closedTrades;
    public double netProfit;
    public double stopLoss;
    public double takeProfit;
    public boolean startDate;
    public double riskRewardGains;
    public boolean vwapOn;
    public String vwapSource;
    public Date lastUpdated = new Date();

    public MovingAverageAlert(String ticker, int movingAverageShortPeriod, int movingAverageLongPeriod,
                              String movingAverage, String source, double averagePercentagePerDay, double profitFactor,
                              int averageBarsInTrade, double averageTrade, double maxDrawdown, double percentProfitable,
                              int closedTrades, double netProfit, double stopLoss, double takeProfit, boolean startDate,
                              double riskRewardGains, boolean vwapOn, String vwapSource) {
        this.ticker = ticker;
        this.movingAverageShortPeriod = movingAverageShortPeriod;
        this.movingAverageLongPeriod = movingAverageLongPeriod;
        this.movingAverage = movingAverage;
        this.source = source;
        this.averagePercentagePerDay = averagePercentagePerDay;
        this.profitFactor = profitFactor;
        this.averageBarsInTrade = averageBarsInTrade;
        this.averageTrade = averageTrade;
        this.maxDrawdown = maxDrawdown;
        this.percentProfitable = percentProfitable;
        this.closedTrades = closedTrades;
        this.netProfit = netProfit;
        this.stopLoss = stopLoss;
        this.takeProfit = takeProfit;
        this.startDate = startDate;
        this.riskRewardGains = riskRewardGains;
        this.vwapOn = vwapOn;
        this.vwapSource = vwapSource;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public int getMovingAverageShortPeriod() {
        return movingAverageShortPeriod;
    }

    public void setMovingAverageShortPeriod(int movingAverageShortPeriod) {
        this.movingAverageShortPeriod = movingAverageShortPeriod;
    }

    public int getMovingAverageLongPeriod() {
        return movingAverageLongPeriod;
    }

    public void setMovingAverageLongPeriod(int movingAverageLongPeriod) {
        this.movingAverageLongPeriod = movingAverageLongPeriod;
    }

    public String getMovingAverage() {
        return movingAverage;
    }

    public void setMovingAverage(String movingAverage) {
        this.movingAverage = movingAverage;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getAveragePercentagePerDay() {
        return averagePercentagePerDay;
    }

    public void setAveragePercentagePerDay(double averagePercentagePerDay) {
        this.averagePercentagePerDay = averagePercentagePerDay;
    }

    public double getProfitFactor() {
        return profitFactor;
    }

    public void setProfitFactor(double profitFactor) {
        this.profitFactor = profitFactor;
    }

    public int getAverageBarsInTrade() {
        return averageBarsInTrade;
    }

    public void setAverageBarsInTrade(int averageBarsInTrade) {
        this.averageBarsInTrade = averageBarsInTrade;
    }

    public double getAverageTrade() {
        return averageTrade;
    }

    public void setAverageTrade(double averageTrade) {
        this.averageTrade = averageTrade;
    }

    public double getMaxDrawdown() {
        return maxDrawdown;
    }

    public void setMaxDrawdown(double maxDrawdown) {
        this.maxDrawdown = maxDrawdown;
    }

    public double getPercentProfitable() {
        return percentProfitable;
    }

    public void setPercentProfitable(double percentProfitable) {
        this.percentProfitable = percentProfitable;
    }

    public int getClosedTrades() {
        return closedTrades;
    }

    public void setClosedTrades(int closedTrades) {
        this.closedTrades = closedTrades;
    }

    public double getNetProfit() {
        return netProfit;
    }

    public void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    public double getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(double stopLoss) {
        this.stopLoss = stopLoss;
    }

    public double getTakeProfit() {
        return takeProfit;
    }

    public void setTakeProfit(double takeProfit) {
        this.takeProfit = takeProfit;
    }

    public boolean isStartDate() {
        return startDate;
    }

    public void setStartDate(boolean startDate) {
        this.startDate = startDate;
    }

    public double getRiskRewardGains() {
        return riskRewardGains;
    }

    public void setRiskRewardGains(double riskRewardGains) {
        this.riskRewardGains = riskRewardGains;
    }

    public boolean isVwapOn() {
        return vwapOn;
    }

    public void setVwapOn(boolean vwapOn) {
        this.vwapOn = vwapOn;
    }

    public String getVwapSource() {
        return vwapSource;
    }

    public void setVwapSource(String vwapSource) {
        this.vwapSource = vwapSource;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "MovingAverageAlert{" +
                "ticker='" + ticker + '\'' +
                ", movingAverageShortPeriod=" + movingAverageShortPeriod +
                ", movingAverageLongPeriod=" + movingAverageLongPeriod +
                ", movingAverage='" + movingAverage + '\'' +
                ", source='" + source + '\'' +
                ", averagePercentagePerDay=" + averagePercentagePerDay +
                ", profitFactor=" + profitFactor +
                ", averageBarsInTrade=" + averageBarsInTrade +
                ", averageTrade=" + averageTrade +
                ", maxDrawdown=" + maxDrawdown +
                ", percentProfitable=" + percentProfitable +
                ", closedTrades=" + closedTrades +
                ", netProfit=" + netProfit +
                ", stopLoss=" + stopLoss +
                ", takeProfit=" + takeProfit +
                ", startDate=" + startDate +
                ", riskRewardGains=" + riskRewardGains +
                ", vwapOn=" + vwapOn +
                ", vwapSource='" + vwapSource + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
