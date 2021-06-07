package com.example.scvet.api.controller;


import com.example.scvet.model.entity.Especialidade;
import com.example.scvet.service.EspecialidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/especialidades")
@RequiredArgsConstructor

public class EspecialidadeController {
    private final EspecialidadeService service;

    @GetMapping()
    public ResponseEntity get(){
        List<Especialidade> especialidades = service.getEspecialidades();
        return ResponseEntity.ok(especialidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        Optional<Especialidade> especialidade = service.getEspecialidadeById(id);
        return ResponseEntity.ok(especialidade);
    }
}
