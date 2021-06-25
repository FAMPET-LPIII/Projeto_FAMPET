package com.example.scvet.api.controller;

import com.example.scvet.api.dto.FuncaoDTO;
import com.example.scvet.model.entity.Funcao;
import com.example.scvet.service.FuncaoService;
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
@RequestMapping("/api/v1/funcoes")
@RequiredArgsConstructor

public class FuncaoController {
    private final FuncaoService service;

    @GetMapping()
    public ResponseEntity get(){
        List<Funcao> funcoes = service.getFuncoes();
        return ResponseEntity.ok(funcoes.stream().map(FuncaoDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        Optional<Funcao> funcao = service.getFuncaoById(id);
        if (!funcao.isPresent()){
            return new ResponseEntity("Função não encontrada.", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(funcao.map(FuncaoDTO::create));
    }
}
