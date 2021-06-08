package com.example.scvet.service;

import com.example.scvet.api.dto.EspecieDTO;
import com.example.scvet.model.entity.Especie;
import com.example.scvet.model.repository.EspecieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EspecieService {

    private EspecieRepository repository;

    public EspecieService(EspecieRepository repository){
        this.repository = repository;
    }

    public List<EspecieDTO> getEspecies(){
        List<EspecieDTO> list = repository.findAll().stream().map(EspecieDTO::create).collect(Collectors.toList());
        return list;
    }

    public EspecieDTO getEspecieById(Long id){
        Optional<Especie> especie = repository.findById(id);
        return especie.map(EspecieDTO::create).orElseThrow(() -> new RuntimeException("Especie não encontrada!"));
    }





}