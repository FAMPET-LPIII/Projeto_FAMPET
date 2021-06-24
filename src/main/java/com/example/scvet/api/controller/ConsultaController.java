package com.example.scvet.api.controller;


import com.example.scvet.api.dto.ConsultaDTO;
import com.example.scvet.api.dto.EspecieDTO;
import com.example.scvet.model.entity.Consulta;
import com.example.scvet.model.entity.Especie;
import com.example.scvet.service.ConsultaService;
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
@RequestMapping("/api/v1/consultas")
@RequiredArgsConstructor

public class ConsultaController {
    private final ConsultaService service;

    @GetMapping()
    public ResponseEntity get(){
        List<Consulta> consultas = service.getConsultas();
        return ResponseEntity.ok(consultas.stream().map(ConsultaDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        Optional<Consulta> consulta = service.getConsultaById(id);
        if(!consulta.isPresent()){
            return new ResponseEntity("Consulta não encontrada", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(consulta.map(ConsultaDTO::create));
    }
}