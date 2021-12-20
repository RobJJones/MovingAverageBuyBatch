package com.tradeapp.movingAverageBuy;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends
        JobExecutionListenerSupport {

    @Autowired
    private MongoOperations template;

    @Override
    public void afterJob(JobExecution jobExecution) {

        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {

            System.out.println("!!! Job Finished !!!");

            long count = template.count(Utils.unscoredAlertQuery(), "alerts");

            System.out.printf("Remaining alerts - %d %n", count);


        }
    }
}
