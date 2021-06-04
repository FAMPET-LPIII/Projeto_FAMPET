package com.example.scvet.service;

import com.example.scvet.api.dto.AnimalDTO;
import com.example.scvet.model.entity.Animal;
import com.example.scvet.model.repository.AnimalRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private AnimalRepository repository;

    public AnimalService(AnimalRepository repository){
        this.repository = repository;
    }

    public List<Animal> getAnimais(){
        return repository.findAll();
    }

    public Optional<Animal> getAnimalById(Long id){
        return repository.findById(id);
    }

}
