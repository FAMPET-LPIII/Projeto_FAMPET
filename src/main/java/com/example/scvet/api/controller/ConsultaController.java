package com.example.scvet.api.controller;


import com.example.scvet.model.entity.Consulta;
import com.example.scvet.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/consultas")
@RequiredArgsConstructor

public class ConsultaController {
    private final ConsultaService service;

    @GetMapping()
    public ResponseEntity get(){
        List<Consulta> especies = service.getConsultas();
        return ResponseEntity.ok(especies);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        Optional<Consulta> animal = service.getConsultaById(id);
        return ResponseEntity.ok(animal);
    }
}