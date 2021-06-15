package com.example.scvet.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Funcionario{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFuncionario;
    private String cpf;
    private String nome;
    private String email;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String telefone;
<<<<<<< HEAD

=======
    @ManyToOne
    private Funcao funcao;
    @ManyToOne
    private Especialidade especialidade;
>>>>>>> parent of efe929a (Revert "Falci_Cliente_Funcionario")
}
