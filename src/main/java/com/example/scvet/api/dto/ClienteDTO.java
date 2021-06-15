package com.example.scvet.api.dto;

import com.example.scvet.model.entity.Cliente;
import com.example.scvet.model.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDTO {

    private Long idCliente;
    private Pessoa pessoa;

    public static ClienteDTO create(Cliente cliente){

        ModelMapper modelMapper = new ModelMapper();
        ClienteDTO dto = modelMapper.map(cliente, ClienteDTO.class);
        return dto;
    }

}
