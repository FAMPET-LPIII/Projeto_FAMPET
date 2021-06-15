package com.example.scvet.service;

import com.example.scvet.api.dto.AgendamentoDTO;
import com.example.scvet.model.entity.Agendamento;
import com.example.scvet.model.repository.AgendamentoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    private AgendamentoRepository repository;

    public AgendamentoService(AgendamentoRepository repository){
        this.repository = repository;
    }

    public List<AgendamentoDTO> getAgendamentos(){
        List<AgendamentoDTO> list = repository.findAll().stream().map(AgendamentoDTO::create).collect(Collectors.toList());
        return list;
    }

    public AgendamentoDTO getAgendamentoById(Long id){
        Optional<Agendamento> agendamento = repository.findById(id);
        return agendamento.map(AgendamentoDTO::create).orElseThrow(() -> new RuntimeException("Agendamento não encontrado."));
    }
}
