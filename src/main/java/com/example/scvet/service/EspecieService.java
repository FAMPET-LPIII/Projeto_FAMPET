package com.example.scvet.service;

import com.example.scvet.exception.RegraNegocioException;
import com.example.scvet.model.entity.Animal;
import com.example.scvet.model.entity.Especie;
import com.example.scvet.model.repository.EspecieRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class EspecieService {

    private EspecieRepository repository;

    public EspecieService(EspecieRepository repository){
        this.repository = repository;
    }

    public List<Especie> getEspecies(){
        return repository.findAll();
    }

    public Optional<Especie> getEspecieById(Long id){
        return  repository.findById(id);
    }

    @Transactional
    public Especie salvar(Especie especie){
        validar(especie);
        return repository.save(especie);
    }

    public void validar(Especie especie){
        if (especie.getNomeEspecie() == null || especie.getNomeEspecie().trim().equals("")){
            throw new RegraNegocioException("Nome de especie invalido");
        }

    }




}