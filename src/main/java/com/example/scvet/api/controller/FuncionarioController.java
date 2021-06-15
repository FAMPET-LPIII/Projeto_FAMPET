package com.example.scvet.api.controller;

import com.example.scvet.model.entity.Funcionario;
import com.example.scvet.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/funcionarios")
@RequiredArgsConstructor

public class FuncionarioController {
    private final FuncionarioService service;

    @GetMapping()
    public ResponseEntity get(){
        List<Funcionario> funcionario = service.getFuncionarios();
        return ResponseEntity.ok(funcionario);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        Optional<Funcionario> funcionario = service.getFuncionarioById(id);
        return ResponseEntity.ok(funcionario);
    }
}
