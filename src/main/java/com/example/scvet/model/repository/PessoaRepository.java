package com.example.scvet.model.repository;

import com.example.scvet.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository  extends JpaRepository<Pessoa, Long>{
}
