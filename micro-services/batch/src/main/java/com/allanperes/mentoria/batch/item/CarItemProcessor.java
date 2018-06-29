package com.allanperes.mentoria.batch.item;

import org.springframework.batch.item.ItemProcessor;

import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class CarItemProcessor implements ItemProcessor<Car, Car> {

    private static final Integer MIN_YEAR = 1900;

    @Override
    public Car process(Car car) throws Exception {
        if (Objects.isNull(car)) {
            return new Car();
        }
        String brand = car.getBrand();
        String color = car.getColor();
        Integer maxYear = Calendar.getInstance().get(Calendar.YEAR);
        int year = ThreadLocalRandom.current().nextInt(MIN_YEAR, maxYear + 1);
        return new Car(brand, color, year);
    }
}
