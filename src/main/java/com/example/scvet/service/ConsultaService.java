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

    public List<ConsultaDTO> getConsultas(){
        List<ConsultaDTO> list = repository.findAll().stream().map(ConsultaDTO::create).collect(Collectors.toList());
        return list;
    }

    public ConsultaDTO getConsultaById(Long id){
        Optional<Consulta> consulta = repository.findById(id);
        return consulta.map(ConsultaDTO::create).orElseThrow(() -> new RuntimeException("Consulta não encontrada!"));
    }

}
