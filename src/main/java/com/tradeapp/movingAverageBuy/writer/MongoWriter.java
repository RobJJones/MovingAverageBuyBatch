package com.tradeapp.movingAverageBuy.writer;

import com.tradeapp.movingAverageBuy.model.MovingAverageAlert;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoWriter {

    @Autowired
    public MongoTemplate template;

    @Bean
    public MongoItemWriter<MovingAverageAlert> alertWriter() {

        return new MongoItemWriterBuilder<MovingAverageAlert>()
                .collection("alertCreated")
                .template(template)
                .build();
    }
}
