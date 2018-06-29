package com.allanperes.mentoria.batch.item;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.item.ItemReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CarItemReader implements ItemReader<Car> {

    @Override
    public Car read() {
        try {
            List<String> colors = getColors();
            List<String> brands = getBrands();
            String brand = brands.get(ThreadLocalRandom.current().nextInt(0, brands.size()));
            String color = colors.get(ThreadLocalRandom.current().nextInt(0, colors.size()));
            return new Car(brand, color);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<String> getBrands() throws IOException {
        return readResourceFileAndReturnValue("/brands.json");
    }

    private List<String> getColors() throws IOException {
        return readResourceFileAndReturnValue("/colors.json");
    }

    private List<String> readResourceFileAndReturnValue(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = CarItemReader.class.getResourceAsStream(filePath);
        return mapper.readValue(is, ArrayList.class);
    }
}
