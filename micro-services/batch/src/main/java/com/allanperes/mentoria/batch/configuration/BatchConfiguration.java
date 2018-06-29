package com.allanperes.mentoria.batch.configuration;

import com.allanperes.mentoria.batch.item.Car;
import com.allanperes.mentoria.batch.item.CarItemProcessor;
import com.allanperes.mentoria.batch.item.CarItemReader;
import com.allanperes.mentoria.batch.item.CarItemWriter;
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
import java.io.Reader;

@Configuration
@EnableBatchProcessing
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
    public CarItemProcessor processor() {
        return new CarItemProcessor();
    }

    @Bean
    public Job createCarJob() {
        return jobBuilderFactory.get("createCarJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Car, Car> chunk(1)
                .reader(new CarItemReader())
                .processor(new CarItemProcessor())
                .writer(new CarItemWriter())
                .build();



    }
}
