package com.example.scvet.service;

import com.example.scvet.api.dto.AgendamentoDTO;
import com.example.scvet.api.dto.FuncaoDTO;
import com.example.scvet.model.entity.Agendamento;
import com.example.scvet.model.entity.Funcao;
import com.example.scvet.model.repository.FuncaoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncaoService {
    private FuncaoRepository repository;

    public FuncaoService(FuncaoRepository repository){
        this.repository = repository;
    }

    public List<FuncaoDTO> getFuncoes(){
        List<FuncaoDTO> list = repository.findAll().stream().map(FuncaoDTO::create).collect(Collectors.toList());
        return list;
    }

    public FuncaoDTO getFuncaoById(Long id){
        Optional<Funcao> funcao = repository.findById(id);
        return funcao.map(FuncaoDTO::create).orElseThrow(() -> new RuntimeException("Funcão não encontrada."));
    }
}
