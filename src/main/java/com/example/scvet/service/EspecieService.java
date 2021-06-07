package com.example.scvet.service;

import com.example.scvet.api.dto.AnimalDTO;
import com.example.scvet.model.entity.Especie;
import com.example.scvet.model.repository.EspecieRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecieService {

    private EspecieRepository repository;

    public EspecieService(EspecieRepository repository){
        this.repository = repository;
    }

    public List<Especie> getEspecies(){
        return repository.findAll();
    }

    public Optional<Especie> getEspecieById(Long id){
        return repository.findById(id);
    }

}