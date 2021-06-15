package com.example.scvet.api.controller;

import com.example.scvet.api.dto.ClienteDTO;
import com.example.scvet.model.entity.Cliente;
import com.example.scvet.service.ClienteService;
import com.example.scvet.service.EspecieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor

public class ClienteController {

    private final ClienteService service;
    @GetMapping()
    public ResponseEntity get(){
        List<ClienteDTO> clientes = service.getClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id){
        ClienteDTO cliente = service.getClienteById(id);
        return ResponseEntity.ok(cliente);
    }
}
