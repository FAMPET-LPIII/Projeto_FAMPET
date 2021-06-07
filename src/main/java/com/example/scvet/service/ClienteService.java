package com.example.scvet.service;

import com.example.scvet.api.dto.ClienteDTO;
import com.example.scvet.model.entity.Cliente;
import com.example.scvet.model.repository.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public List<Cliente> getClientes(){
        return repository.findAll();
    }

    public Optional<Cliente> getClienteById(Long id){
        return repository.findById(id);
    }
}
