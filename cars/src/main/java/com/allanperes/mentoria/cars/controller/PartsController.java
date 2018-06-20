package com.allanperes.mentoria.cars.controller;

import com.allanperes.mentoria.cars.model.Parts;
import com.allanperes.mentoria.cars.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parts")
public class PartsController {

    @Autowired
    private PartsService partsService;

    @GetMapping("/all")
    public List<Parts> findAll() {
        return partsService.findAll();
    }
}
