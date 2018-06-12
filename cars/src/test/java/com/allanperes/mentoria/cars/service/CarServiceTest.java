package com.allanperes.mentoria.cars.service;

import com.allanperes.mentoria.cars.model.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class CarServiceTest {

    @InjectMocks
    private CarService carService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_recover_cars() {
        List<Car> cars = carService.findAll();
        assertEquals(2, cars.size());
    }
}
