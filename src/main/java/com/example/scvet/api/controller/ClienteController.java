package com.example.scvet.api.controller;

import com.example.scvet.api.dto.*;
import com.example.scvet.exception.RegraNegocioException;
import com.example.scvet.model.entity.Cliente;
import com.example.scvet.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor

public class ClienteController {

    private final ClienteService service;

    @GetMapping()
    public ResponseEntity get() {
        List<Cliente> clientes = service.getClientes();
        return ResponseEntity.ok(clientes.stream().map(ClienteDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Cliente> cliente = service.getClienteById(id);

        if (!cliente.isPresent()) {
            return new ResponseEntity("Cliente não encontrado", HttpStatus.NOT_FOUND);

        }
        return ResponseEntity.ok(cliente.map(ClienteDTO::create));
    }

    @GetMapping("/{id}/animais")
    public ResponseEntity getAnimais(@PathVariable long id) {
        Optional<Cliente> cliente = service.getClienteById(id);
        if (!cliente.isPresent()) {
            return new ResponseEntity("Cliente não encontrado.", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(cliente.get().getAnimais().stream().map(AnimalDTO::create).collect(Collectors.toList()));
    }

    @PostMapping()
    public ResponseEntity post(ClienteDTO dto) {
        try {
            Cliente cliente = converter(dto);
            cliente = service.salvar(cliente);
            return new ResponseEntity(cliente, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public Cliente converter(ClienteDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Cliente.class);
    }
}
