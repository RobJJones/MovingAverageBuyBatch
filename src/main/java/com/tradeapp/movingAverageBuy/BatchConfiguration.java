package com.tradeapp.movingAverageBuy;

import com.tradeapp.movingAverageBuy.model.MovingAverageAlert;
import com.tradeapp.movingAverageBuy.writer.DummyWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.mongodb.core.MongoTemplate;

@EnableBatchProcessing
@Configuration
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public MongoTemplate template;

    @Autowired
    public MongoItemReader<MovingAverageAlert> alertReader;

    @Autowired
    public MongoItemWriter<MovingAverageAlert> alertWriter;

    @Bean
    public AlertItemProcessor processor() {
        return new AlertItemProcessor();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor("spring_batch");
    }

    @Bean
    public Job maBatchBuyAlertJob(JobCompletionNotificationListener
        listener, Step step1) {

        return jobBuilderFactory.get("maBatchBuyAlertJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1() {

        return stepBuilderFactory.get("step1")
                .<MovingAverageAlert, MovingAverageAlert>chunk(10)
                .reader(alertReader)
                .processor(processor())
                .writer(alertWriter)
                .taskExecutor(taskExecutor())
                .throttleLimit(4)
                .build();
    }

    @Bean
    public Step step2() {

        return stepBuilderFactory.get("step2")
                .<MovingAverageAlert, MovingAverageAlert>chunk(10)
                .reader(alertReader)
                .processor(processor())
                .writer(alertWriter)
                .build();
    }
}
