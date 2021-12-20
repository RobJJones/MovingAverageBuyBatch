package com.tradeapp.movingAverageBuy.model;

import com.tradeapp.movingAverageBuy.Utils;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.MultiResourceItemReader;

import java.math.BigDecimal;


public class TickerLineMapper implements LineMapper<Ticker> {

    private MultiResourceItemReader delegator;

    public TickerLineMapper(MultiResourceItemReader delegator) {
        this.delegator = delegator;
    }

    @Override
    public Ticker mapLine(String line, int lineNumber) throws Exception {
        String[] fields = line.split(",");
        /*ArrayList<String> fieldList = new ArrayList<>();

        for (int i = 0; i < fields.length; i++) {
            fieldList.add(fields[i].replaceAll("\"", "");
        }*/

        String[] fileName = delegator.getCurrentResource().getFilename().split("/");

        Ticker ticker = new Ticker();
        //ticker.setTicker(fileName[fileName.length - 1]);
        //ticker.setExchange("TESTE");
        ticker.setTime(Utils.dateTimeFormatter.parse(fields[0]));
        ticker.setOpen(new BigDecimal(fields[1]));
        ticker.setHigh(new BigDecimal(fields[2]));
        ticker.setLow(new BigDecimal(fields[3]));
        ticker.setClose(new BigDecimal(fields[4]));
        ticker.setDailyOpen(new BigDecimal(fields[5]));
        ticker.setDailyClose(new BigDecimal(fields[6]));
        ticker.setKeltnerUpper(new BigDecimal(fields[7]));
        ticker.setKeltnerBasis(new BigDecimal(fields[8]));
        ticker.setKeltnerLower(new BigDecimal(fields[9]));
        ticker.setVwma(new BigDecimal(fields[0]));
        ticker.setEma200(new BigDecimal(fields[0]));
        ticker.setVwap(new BigDecimal(fields[0]));
        ticker.setVwapUpperBand(new BigDecimal(fields[0]));
        ticker.setVwapLowerBand(new BigDecimal(fields[0]));
        ticker.setVolume(new BigDecimal(fields[0]));
        ticker.setVolumeMA(new BigDecimal(fields[0]));
        ticker.setRating(new BigDecimal(fields[0]));
        ticker.setMacdHistogram(new BigDecimal(fields[0]));
        ticker.setMacdLevel(new BigDecimal(fields[0]));
        ticker.setMacdSignal(new BigDecimal(fields[0]));
        ticker.setRsi(new BigDecimal(fields[0]));
        ticker.setAverageTrueRange(new BigDecimal(fields[0]));
        ticker.setChaikinMF(new BigDecimal(fields[0]));
        ticker.setMomentum(new BigDecimal(fields[0]));
        ticker.setStockK(new BigDecimal(fields[0]));
        ticker.setStockD(new BigDecimal(fields[0]));
        ticker.setAverageDirIndex(new BigDecimal(fields[0]));
        ticker.setAwesomeOscillator(new BigDecimal(fields[0]));
        ticker.setComChannelIndex(new BigDecimal(fields[0]));

        return ticker;
    }
}
