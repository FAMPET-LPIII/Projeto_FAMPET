package com.example.scvet.api.controller;


import com.example.scvet.model.entity.Especie;
import com.example.scvet.service.EspecieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/especies")
@RequiredArgsConstructor

public class EspecieController {
    private final EspecieService service;

    @GetMapping()
    public ResponseEntity get(){
        List<Especie> especies = service.getEspecies();
        return ResponseEntity.ok(especies);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        Optional<Especie> animal = service.getEspecieById(id);
        return ResponseEntity.ok(animal);
    }
}