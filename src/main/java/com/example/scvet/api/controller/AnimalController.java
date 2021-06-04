package com.example.scvet.api.controller;


import com.example.scvet.model.entity.Animal;
import com.example.scvet.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/animais")
@RequiredArgsConstructor

public class AnimalController {
    private final AnimalService service;

    @GetMapping()
    public ResponseEntity get(){
        List<Animal> animais = service.getAnimais();
        return ResponseEntity.ok(animais);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        Optional<Animal> animal = service.getAnimalById(id);
        return ResponseEntity.ok(animal);
    }
}
