package com.allanperes.mentoria.batch.item;

import com.allanperes.mentoria.batch.configuration.ServicesProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static java.lang.String.format;

@Service
public class CarService {

    private static final Logger log = LoggerFactory.getLogger(CarTasklet.class);

    @Autowired
    private ServicesProperties servicesProperties;

    @Autowired
    private CarFactory carFactory;

    public void postCar() {
        final String uri = format("http://%s/cars/cars", servicesProperties.getGatewayUri());
        System.out.println("Job run");
        try {
            Car randomCar = carFactory.createCar();
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(uri, randomCar, Car.class);
        } catch (ResourceAccessException e) {
            log.error("O serviço não está disponível " + uri);
        } catch (IOException e) {
            log.error("Não foi possível encontrar o arquivo " + e.getMessage());
        }
    }
}
