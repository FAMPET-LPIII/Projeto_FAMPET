package com.example.scvet.api.controller;

import com.example.scvet.api.dto.EspecialidadeDTO;
import com.example.scvet.api.dto.FuncaoDTO;
import com.example.scvet.exception.RegraNegocioException;
import com.example.scvet.model.entity.Especialidade;
import com.example.scvet.model.entity.Funcao;
import com.example.scvet.service.FuncaoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity post(FuncaoDTO dto){
        try {
            Funcao funcao = converter(dto);
            funcao = service.salvar(funcao);
            return new ResponseEntity(get(funcao.getIdFuncao()), HttpStatus.CREATED);
        }catch(RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public Funcao converter (FuncaoDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        Funcao funcao = modelMapper.map(dto, Funcao.class);
        return funcao;
    }
}
