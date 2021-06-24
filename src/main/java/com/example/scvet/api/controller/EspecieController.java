package com.example.scvet.api.controller;

import com.example.scvet.api.dto.EspecieDTO;
import com.example.scvet.model.entity.Especie;
import com.example.scvet.service.EspecieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/especies")
@RequiredArgsConstructor

public class EspecieController {
    private final EspecieService service;

    @GetMapping()
    public ResponseEntity get(){
        List<Especie> especies = service.getEspecies();
        return ResponseEntity.ok(especies.stream().map(EspecieDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        Optional<Especie> especie = service.getEspecieById(id);
        if(!especie.isPresent()){
            return new ResponseEntity("Especie não encontrada", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(especie.map(EspecieDTO::create));
    }
}