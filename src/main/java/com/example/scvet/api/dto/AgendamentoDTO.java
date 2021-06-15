package com.example.scvet.api.dto;

import com.example.scvet.model.entity.Agendamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AgendamentoDTO {

    private long idAgendamento;
    private String data;
    private String hora;
    private String situacao;


    private Long idAtendente;
    private String nomeAtendente;
    private Long idCliente;
    private String nomeCliente;

    public static AgendamentoDTO create(Agendamento agendamento){

        ModelMapper modelMapper = new ModelMapper();
        AgendamentoDTO dto = modelMapper.map(agendamento, AgendamentoDTO.class);
        assert dto.getIdAtendente().equals(agendamento.getFuncionario().getIdFuncionario());
        assert dto.getNomeAtendente().equals(agendamento.getFuncionario().getNome());
        assert dto.getIdCliente().equals(agendamento.getCliente().getIdCliente());
        assert dto.getNomeCliente().equals(agendamento.getCliente().getNome());
        return dto;
    }
}

