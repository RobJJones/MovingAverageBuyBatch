package com.tradeapp.movingAverageBuy.reader;

import com.tradeapp.movingAverageBuy.model.MovingAverageAlert;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.data.builder.MongoItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Configuration
public class MongoReader {

    @Autowired
    public MongoTemplate template;

    @Bean
    public MongoItemReader<MovingAverageAlert> alertReader() {
        Map<String, Sort.Direction> sorts
                = new HashMap<>() {{
            put("averagePercentagePerDay", Sort.Direction.DESC);
        }};

        Query query = new Query(where("ticker").exists(true));
        return new MongoItemReaderBuilder<MovingAverageAlert>()
                .name("maViewReader")
                .collection("view_ma_strategy_30")
                .query(query)
                .sorts(sorts)
                .template(template)
                .targetType(MovingAverageAlert.class)
                .maxItemCount(1)
                .build();
    }
}
