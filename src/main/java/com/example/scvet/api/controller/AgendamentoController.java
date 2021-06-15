package com.example.scvet.api.controller;

import com.example.scvet.api.dto.AgendamentoDTO;
import com.example.scvet.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/agendamentos")
@RequiredArgsConstructor

public class AgendamentoController {
    private final AgendamentoService service;

    @GetMapping()
    public ResponseEntity get(){
        List<AgendamentoDTO> agendamentos = service.getAgendamentos();
        return ResponseEntity.ok(agendamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        AgendamentoDTO agendamento = service.getAgendamentoById(id);
        return ResponseEntity.ok(agendamento);
    }
}
