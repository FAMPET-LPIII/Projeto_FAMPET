package com.example.scvet.service;

import com.example.scvet.api.dto.AnimalDTO;
import com.example.scvet.model.entity.Animal;
import com.example.scvet.model.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    private AnimalRepository repository;

    public AnimalService(AnimalRepository repository){
        this.repository = repository;
    }

    public List<AnimalDTO> getAnimais(){
        List<AnimalDTO> list = repository.findAll().stream().map(AnimalDTO::create).collect(Collectors.toList());
        return list;
    }

    public AnimalDTO getAnimalById(Long id){
        Optional<Animal> animal = repository.findById(id);
        return animal.map(AnimalDTO::create).orElseThrow(() -> new RuntimeException("Animal não encontrado!"));
    }

}
