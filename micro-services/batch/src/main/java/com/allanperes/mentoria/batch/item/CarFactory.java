package com.allanperes.mentoria.batch.item;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class CarFactory {

    private static final Integer MIN_YEAR = 1900;

    public Car createCar() throws IOException {
        List<String> colors = getColors();
        List<String> brands = getBrands();
        String brand = brands.get(ThreadLocalRandom.current().nextInt(0, brands.size()));
        String color = colors.get(ThreadLocalRandom.current().nextInt(0, colors.size()));
        Integer maxYear = Calendar.getInstance().get(Calendar.YEAR);
        int year = ThreadLocalRandom.current().nextInt(MIN_YEAR, maxYear + 1);
        return new Car(brand, color, year);
    }

    private List<String> getBrands() throws IOException {
        return readResourceFileAndReturnValue("/brands.json");
    }

    private List<String> getColors() throws IOException {
        return readResourceFileAndReturnValue("/colors.json");
    }

    private List<String> readResourceFileAndReturnValue(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = CarFactory.class.getResourceAsStream(filePath);
        return mapper.readValue(is, ArrayList.class);
    }
}
