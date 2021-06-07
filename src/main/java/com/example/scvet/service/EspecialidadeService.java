package com.example.scvet.service;

import com.example.scvet.api.dto.EspecialidadeDTO;
import com.example.scvet.model.entity.Especialidade;
import com.example.scvet.model.repository.EspecialidadeRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadeService {

    private EspecialidadeRepository repository;

    public EspecialidadeService(EspecialidadeRepository repository){
        this.repository = repository;
    }

    public List<Especialidade> getEspecialidades(){
        return repository.findAll();
    }

    public Optional<Especialidade> getEspecialidadeById(Long id){
        return repository.findById(id);
    }

}
