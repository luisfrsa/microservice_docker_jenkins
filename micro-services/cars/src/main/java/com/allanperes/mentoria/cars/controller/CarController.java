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
    public Car findCarById(@PathVariable("id") Long id) {
        System.out.println(id);
        return carService.findById(id);
    }

    @GetMapping("/by-brand/{brand}")
    public List<Car> findCarByBrand(@PathVariable("brand") String brand) {
        return carService.findCarByBrand(brand);
    }

    @PostMapping
    public Car save(@RequestBody Car car) {
        return carService.save(car);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        return carService.delete(id);
    }
}
