package com.tradeapp.movingAverageBuy;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class Utils {

    public static SimpleDateFormat dateTimeFormatter =
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");

    public static Query unscoredAlertQuery() {
        //Query all stocks that have not been scored
        Sort sort = Sort.by(Sort.Direction.DESC, "dateTime");
        return new Query(where("score").is(0))
                .addCriteria(where("low").is(0))
                .addCriteria(where("high").is(0))
                .with(sort);
    }

    public static String formatDateToString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String formatDateToTimeString(Date date) {
        return new SimpleDateFormat("HH:mm").format(date);
    }

    public static String dateToDirectoryName(Date date) {
        return new SimpleDateFormat("_yyyyMMdd/").format(date);
    }

}
