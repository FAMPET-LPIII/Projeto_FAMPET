package com.example.scvet.service;

import com.example.scvet.api.dto.FuncionarioDTO;
import com.example.scvet.model.entity.Funcionario;
import com.example.scvet.model.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {
    private FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository){
        this.repository = repository;
    }

    public List<FuncionarioDTO> getFuncionarios(){
        List<FuncionarioDTO> list = repository.findAll().stream().map(FuncionarioDTO::create).collect(Collectors.toList());
        return list;
    }

    public FuncionarioDTO getFuncionarioById(Long id){
        Optional<Funcionario> funcionario = repository.findById(id);
        return funcionario.map(FuncionarioDTO::create).orElseThrow(() -> new RuntimeException("Funcionario não encontrado!"));
    }
}
