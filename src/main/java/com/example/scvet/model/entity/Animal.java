package com.example.scvet.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor



public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnimal;
    private String nome;
    private double peso;
    private String sexo;

    @ManyToOne
    private Especie especie;

    @ManyToOne
    private Cliente cliente;





}
