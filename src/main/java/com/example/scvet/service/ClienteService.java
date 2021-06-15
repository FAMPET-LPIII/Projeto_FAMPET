package com.example.scvet.service;


import com.example.scvet.api.dto.AnimalDTO;
import com.example.scvet.api.dto.ClienteDTO;
import com.example.scvet.model.entity.Animal;
import com.example.scvet.model.entity.Cliente;
import com.example.scvet.model.repository.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public List<ClienteDTO> getClientes(){
        List<ClienteDTO> list = repository.findAll().stream().map(ClienteDTO::create).collect(Collectors.toList());
        return list;
    }

    public ClienteDTO getClienteById(Long id){
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.map(ClienteDTO::create).orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }
}
