package com.example.scvet.service;

import com.example.scvet.model.entity.Agendamento;
import com.example.scvet.model.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository){
        this.repository = repository;
    }

    public List<Agendamento> getAgendamentos(){
        return repository.findAll();
    }

    public Optional<Agendamento> getAgendamentoById(Long id){
        return repository.findById(id);
    }
}
