package com.tradeapp.movingAverageBuy.model;

import com.opencsv.bean.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.util.Date;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;

@Document
public class Ticker {

//time,open,high,low,close,Daily_Open,Daily_Close,Upper,Basis,Lower,VWMA,EMA,VWAP,Upper Band,Lower Band,Volume,Volume MA,Rating,Histogram,MACD,Signal,RSI,ATR,MF,MOM,%K,%D,ADX,Plot,CCI
//2021-07-21T08:00:00Z,22.20284393982479,22.22,22.20284393982479,22.22,22.58383398702323,22.09306,22.239912238492696,22.197995192723866,22.156078146955036,22.245635021097225,22.056475854798023,22.215981452751873,22.276953772889147,22.155009132614598,5743,649.7,0.2909090909090909,-0.02286773625958967,0.05245393443572155,0.07532167069531122,56.0515710023341,0.04614603908047837,0.7164618048922242,-0.08000000000000185,6.249999999999308,16.34771405792984,55.10895165516414,0.10536465995130229,-48.086657601570046

    @CsvDate("yyyy-MM-dd'T'HH:mm:ssX")
    @CsvBindByName
    private Date time;

    @CsvCustomBindByName(converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal open;

    @CsvCustomBindByName(converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal high;

    @CsvCustomBindByName(converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal low;

    @CsvCustomBindByName(converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal close;

    @CsvCustomBindByName(column = "Daily_Open", converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal dailyOpen;

    @CsvCustomBindByName(column = "Daily_Close", converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal dailyClose;

    @CsvCustomBindByName(column = "Upper", converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal keltnerUpper;

    @CsvCustomBindByName(column = "Basis", converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal keltnerBasis;

    @CsvCustomBindByName(column = "Lower", converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal keltnerLower;

    @CsvCustomBindByName(column = "VWMA", converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal vwma;

    @CsvCustomBindByName(column = "EMA", converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal ema200;

    @CsvCustomBindByName(column = "VWAP", converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal vwap;
    @CsvCustomBindByName(column = "Upper Band",converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal vwapUpperBand;
    @CsvCustomBindByName(column = "Lower Band",converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal vwapLowerBand;

    @CsvCustomBindByName(column = "Volume", converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal volume;

    @CsvCustomBindByName(column = "Volume MA", converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal volumeMA;

    @CsvCustomBindByName(column = "Rating" , converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal rating;

    @CsvCustomBindByName(column = "Histogram" , converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal macdHistogram;

    @CsvCustomBindByName(column = "MACD" , converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal macdLevel;

    @CsvCustomBindByName(column = "Signal" , converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal macdSignal;

    @CsvCustomBindByName(column = "RSI" , converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal rsi;

    @CsvCustomBindByName(column = "ATR" , converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal averageTrueRange;

    @CsvCustomBindByName(column = "MF" , converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal chaikinMF;

    @CsvCustomBindByName(column = "MOM" , converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal momentum;

    @CsvCustomBindByName(column = "%K" , converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal stockK;

    @CsvCustomBindByName(column = "%D" , converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal stockD;

    @CsvCustomBindByName(column = "ADX" , converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal averageDirIndex;

    @CsvCustomBindByName(column = "Plot" , converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal awesomeOscillator;

    @CsvCustomBindByName(column = "CCI" , converter = BigDecimalNaNConverter.class)
    @Field(targetType = DECIMAL128)
    private BigDecimal comChannelIndex;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) { this.time = time; }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getDailyOpen() {
        return dailyOpen;
    }

    public void setDailyOpen(BigDecimal dailyOpen) {
        this.dailyOpen = dailyOpen;
    }

    public BigDecimal getDailyClose() {
        return dailyClose;
    }

    public void setDailyClose(BigDecimal dailyClose) {
        this.dailyClose = dailyClose;
    }

    public BigDecimal getKeltnerUpper() {
        return keltnerUpper;
    }

    public void setKeltnerUpper(BigDecimal keltnerUpper) {
        this.keltnerUpper = keltnerUpper;
    }

    public BigDecimal getKeltnerBasis() {
        return keltnerBasis;
    }

    public void setKeltnerBasis(BigDecimal keltnerBasis) {
        this.keltnerBasis = keltnerBasis;
    }

    public BigDecimal getKeltnerLower() {
        return keltnerLower;
    }

    public void setKeltnerLower(BigDecimal keltnerLower) {
        this.keltnerLower = keltnerLower;
    }

    public BigDecimal getVwma() {
        return vwma;
    }

    public void setVwma(BigDecimal vwma) {
        this.vwma = vwma;
    }

    public BigDecimal getEma200() {
        return ema200;
    }

    public void setEma200(BigDecimal ema200) {
        this.ema200 = ema200;
    }

    public BigDecimal getVwap() {
        return vwap;
    }

    public void setVwap(BigDecimal vwap) {
        this.vwap = vwap;
    }

    public BigDecimal getVwapUpperBand() {
        return vwapUpperBand;
    }

    public void setVwapUpperBand(BigDecimal vwapUpperBand) {
        this.vwapUpperBand = vwapUpperBand;
    }

    public BigDecimal getVwapLowerBand() {
        return vwapLowerBand;
    }

    public void setVwapLowerBand(BigDecimal vwapLowerBand) {
        this.vwapLowerBand = vwapLowerBand;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getVolumeMA() {
        return volumeMA;
    }

    public void setVolumeMA(BigDecimal volumeMA) {
        this.volumeMA = volumeMA;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public BigDecimal getMacdHistogram() {
        return macdHistogram;
    }

    public void setMacdHistogram(BigDecimal macdHistogram) {
        this.macdHistogram = macdHistogram;
    }

    public BigDecimal getMacdLevel() {
        return macdLevel;
    }

    public void setMacdLevel(BigDecimal macdLevel) {
        this.macdLevel = macdLevel;
    }

    public BigDecimal getMacdSignal() {
        return macdSignal;
    }

    public void setMacdSignal(BigDecimal macdSignal) {
        this.macdSignal = macdSignal;
    }

    public BigDecimal getRsi() {
        return rsi;
    }

    public void setRsi(BigDecimal rsi) {
        this.rsi = rsi;
    }

    public BigDecimal getAverageTrueRange() {
        return averageTrueRange;
    }

    public void setAverageTrueRange(BigDecimal averageTrueRange) {
        this.averageTrueRange = averageTrueRange;
    }

    public BigDecimal getChaikinMF() {
        return chaikinMF;
    }

    public void setChaikinMF(BigDecimal chaikinMF) {
        this.chaikinMF = chaikinMF;
    }

    public BigDecimal getMomentum() {
        return momentum;
    }

    public void setMomentum(BigDecimal momentum) {
        this.momentum = momentum;
    }

    public BigDecimal getStockK() {
        return stockK;
    }

    public void setStockK(BigDecimal stockK) {
        this.stockK = stockK;
    }

    public BigDecimal getStockD() {
        return stockD;
    }

    public void setStockD(BigDecimal stockD) {
        this.stockD = stockD;
    }

    public BigDecimal getAverageDirIndex() {
        return averageDirIndex;
    }

    public void setAverageDirIndex(BigDecimal averageDirIndex) {
        this.averageDirIndex = averageDirIndex;
    }

    public BigDecimal getAwesomeOscillator() {
        return awesomeOscillator;
    }

    public void setAwesomeOscillator(BigDecimal awesomeOscillator) {
        this.awesomeOscillator = awesomeOscillator;
    }

    public BigDecimal getComChannelIndex() {
        return comChannelIndex;
    }

    public void setComChannelIndex(BigDecimal comChannelIndex) {
        this.comChannelIndex = comChannelIndex;
    }

    @Override
    public String toString() {
        return "Ticker{" +
                "time=" + time +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", dailyOpen=" + dailyOpen +
                ", dailyClose=" + dailyClose +
                ", keltnerUpper=" + keltnerUpper +
                ", keltnerBasis=" + keltnerBasis +
                ", keltnerLower=" + keltnerLower +
                ", vwma=" + vwma +
                ", ema200=" + ema200 +
                ", vwap=" + vwap +
                ", vwapUpperBand=" + vwapUpperBand +
                ", vwapLowerBand=" + vwapLowerBand +
                ", volume=" + volume +
                ", volumeMA=" + volumeMA +
                ", rating=" + rating +
                ", macdHistogram=" + macdHistogram +
                ", macdLevel=" + macdLevel +
                ", macdSignal=" + macdSignal +
                ", rsi=" + rsi +
                ", averageTrueRange=" + averageTrueRange +
                ", chaikinMF=" + chaikinMF +
                ", momentum=" + momentum +
                ", stockK=" + stockK +
                ", stockD=" + stockD +
                ", averageDirIndex=" + averageDirIndex +
                ", awesomeOscillator=" + awesomeOscillator +
                ", comChannelIndex=" + comChannelIndex +
                '}';
    }
}
