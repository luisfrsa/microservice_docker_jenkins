package com.allanperes.mentoria.cars.service;

import com.allanperes.mentoria.cars.model.Car;
import com.allanperes.mentoria.cars.model.repository.CarRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarServiceTest {

    @MockBean
    private CarService carService;

    @Autowired
    private CarRepository carRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_recover_cars() {
        List<Car> cars = carService.findAll();
        assertEquals(0, cars.size());
    }
}
