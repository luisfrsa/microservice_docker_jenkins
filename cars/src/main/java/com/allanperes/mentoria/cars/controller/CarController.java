package com.allanperes.mentoria.cars.controller;

import com.allanperes.mentoria.cars.model.Car;
import com.allanperes.mentoria.cars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/all")
    public List<Car> findAll() {
        return carService.findAll();
    }

    @GetMapping("/by-id/{id}")
    public Car findById(@PathParam("id") Long id) {
        return carService.findById(id);
    }

    @GetMapping("/by-brand/{brand}")
    public List<Car> findCarById(@PathParam("brand") String brand) {
        return carService.findCarByBrand(brand);
    }

    @PostMapping()
    public Car save(Car car) {
        return carService.save(car);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathParam("id") Long id) {
        return carService.delete(id);
    }
}
