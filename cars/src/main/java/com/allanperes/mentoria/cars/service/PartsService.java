package com.allanperes.mentoria.cars.service;

import com.allanperes.mentoria.cars.model.Parts;
import com.allanperes.mentoria.cars.model.repository.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsService {

    @Autowired
    private PartsRepository partsRepository;

    public List<Parts> findAll() {
        return partsRepository.findAll();
    }

}
