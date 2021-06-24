package com.example.scvet.service;

import com.example.scvet.api.dto.ConsultaDTO;
import com.example.scvet.model.entity.Consulta;
import com.example.scvet.model.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultaService {

    private ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository){
        this.repository = repository;
    }

    public List<Consulta> getConsultas(){
        return repository.findAll();
    }

    public Optional<Consulta> getConsultaById(Long id){
        return  repository.findById(id);
    }

}
