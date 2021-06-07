package com.example.scvet.service;

import com.example.scvet.model.entity.Pessoa;
import com.example.scvet.model.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    private PessoaRepository repository;

    public PessoaService(PessoaRepository repository){
        this.repository = repository;
    }

    public List<Pessoa> getPessoas(){
        return repository.findAll();
    }

    public Optional<Pessoa> getPessoaById(Long id){
        return repository.findById(id);
    }
}
