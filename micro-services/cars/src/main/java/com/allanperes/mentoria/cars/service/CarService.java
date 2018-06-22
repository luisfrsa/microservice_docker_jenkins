package com.allanperes.mentoria.cars.service;

import com.allanperes.mentoria.cars.model.Car;
import com.allanperes.mentoria.cars.model.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static java.lang.String.format;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(format("Não encontrado carro com o id %s", id)));
    }

    public List<Car> findCarByBrand(String brand) {
        return carRepository.findByBrand(brand);
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public String delete(Long id) {
        try {
            carRepository.delete(findById(id));
            return "Carro deletado com sucesso";
        } catch (Exception e) {
            return "Não foi possível deletar o carro";
        }
    }
}
