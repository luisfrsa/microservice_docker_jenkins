package com.allanperes.mentoria.batch.item;

import org.springframework.batch.item.ItemWriter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CarItemWriter implements ItemWriter<Car> {

    @Override
    public void write(List<? extends Car> list) throws Exception {
        final String uri = "http://localhost:8080/cars/cars";
        for (Car car : list) {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(uri, car, Car.class);
        }
    }
}
