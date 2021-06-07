package com.example.scvet.service;

import com.example.scvet.model.entity.Funcionario;
import com.example.scvet.model.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository){
        this.repository = repository;
    }

    public List<Funcionario> getFuncionarios(){
        return repository.findAll();
    }

    public Optional<Funcionario> getFuncionarioById(Long id){
        return repository.findById(id);
    }
}
