package com.example.scvet.service;

import com.example.scvet.api.dto.AgendamentoDTO;
import com.example.scvet.api.dto.EspecialidadeDTO;
import com.example.scvet.model.entity.Agendamento;
import com.example.scvet.model.entity.Especialidade;
import com.example.scvet.model.repository.EspecialidadeRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EspecialidadeService {

    private EspecialidadeRepository repository;

    public EspecialidadeService(EspecialidadeRepository repository){
        this.repository = repository;
    }

    public List<EspecialidadeDTO> getEspecialidades(){
        List<EspecialidadeDTO> list = repository.findAll().stream().map(EspecialidadeDTO::create).collect(Collectors.toList());
        return list;
    }

    public EspecialidadeDTO getEspecialidadeById(Long id){
        Optional<Especialidade> especialidade = repository.findById(id);
        return especialidade.map(EspecialidadeDTO::create).orElseThrow(() -> new RuntimeException("Especialidade não encontrada."));
    }

}
