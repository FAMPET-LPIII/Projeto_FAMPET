package com.example.scvet.api.controller;

import com.example.scvet.api.dto.EspecialidadeDTO;
import com.example.scvet.exception.RegraNegocioException;
import com.example.scvet.model.entity.Especialidade;
import com.example.scvet.service.EspecialidadeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/especialidades")
@RequiredArgsConstructor

public class EspecialidadeController {
    private final EspecialidadeService service;

    @GetMapping()
    public ResponseEntity get(){
        List<Especialidade> especialidades = service.getEspecialidades();
        return ResponseEntity.ok(especialidades.stream().map(EspecialidadeDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        Optional<Especialidade> especialidade = service.getEspecialidadeById(id);
        if(!especialidade.isPresent()){
            return new ResponseEntity("Especialidade não encontrada.", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(especialidade.map(EspecialidadeDTO::create));
    }

    @PostMapping
    public ResponseEntity post(EspecialidadeDTO dto){
        try {
            Especialidade especialidade = converter(dto);
            especialidade = service.salvar(especialidade);
            return new ResponseEntity(get(especialidade.getIdEspecialidade()), HttpStatus.CREATED);
        }catch(RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public Especialidade converter (EspecialidadeDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        Especialidade especialidade = modelMapper.map(dto, Especialidade.class);
        return especialidade;
    }
}
