package com.example.scvet.model.repository;

import com.example.scvet.model.entity.Animal;
import com.example.scvet.model.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConsultaRepository  extends JpaRepository<Consulta, Long>{

    List<Consulta> findByAnimal(Optional<Animal> animal);
}
