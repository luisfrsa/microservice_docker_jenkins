package com.allanperes.mentoria.cars.service;

import com.allanperes.mentoria.cars.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Buggatti", 2017L, "Black"));
        cars.add(new Car("Ferrari", 1991L, "Red"));
        return cars;
    }

}
