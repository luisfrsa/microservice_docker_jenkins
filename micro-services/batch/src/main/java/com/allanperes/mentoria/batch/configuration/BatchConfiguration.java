package com.allanperes.mentoria.batch.configuration;

import com.allanperes.mentoria.batch.item.*;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class BatchConfiguration extends DefaultBatchConfigurer {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Override
    public void setDataSource(DataSource dataSource) {
        return;
    }

    @Bean
    public Job createCarJob() {
        return jobBuilderFactory.get("createCarJob")
                .preventRestart()
                .start(step1())
                .build();
    }

    @Bean
    public CarTasklet createTasklet() {
        return new CarTasklet();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet(createTasklet())
                .build();
    }
}
