package com.allanperes.mentoria.cars.controller;

import com.allanperes.mentoria.cars.model.Car;
import com.allanperes.mentoria.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<Car> findAll() {
        return carService.findAll();
    }
}
