package com.example.scvet.api.dto;

import com.example.scvet.model.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDTO {

    private Long idCliente;
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
    private Long idAnimal;
    private String nomeAnimal;

    public static ClienteDTO create(Cliente cliente){

        ModelMapper modelMapper = new ModelMapper();
        ClienteDTO dto = modelMapper.map(cliente, ClienteDTO.class);
        assert dto.getIdAnimal().equals(cliente.getAnimal().getIdAnimal());
        assert dto.getIdAnimal().equals(cliente.getAnimal().getNome());
        return dto;
    }

}
