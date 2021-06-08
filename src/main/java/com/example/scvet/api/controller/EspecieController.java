package com.example.scvet.api.controller;


import com.example.scvet.api.dto.EspecieDTO;
import com.example.scvet.service.EspecieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/especies")
@RequiredArgsConstructor

public class EspecieController {
    private final EspecieService service;

    @GetMapping()
    public ResponseEntity get(){
        List<EspecieDTO> especies = service.getEspecies();
        return ResponseEntity.ok(especies);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
       EspecieDTO especie = service.getEspecieById(id);
        return ResponseEntity.ok(especie);
    }
}