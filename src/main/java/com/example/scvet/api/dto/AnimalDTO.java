package com.example.scvet.api.dto;

import com.example.scvet.model.entity.Animal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AnimalDTO {

    private Long idAnimal;
    private String nomeAnimal;
    private double peso;
    private String sexo;
    private Long idCliente;
//    private String nomeCliente;
    private Long idEspecie;
//    private String nomeEspecie;


    public static AnimalDTO create(Animal animal){

        ModelMapper modelMapper = new ModelMapper();
        AnimalDTO dto = modelMapper.map(animal, AnimalDTO.class);
        assert dto.getIdCliente().equals(animal.getCliente().getIdCliente());
//      assert dto.getNomeCliente().equals(animal.getCliente().getNome());
        assert dto.getIdEspecie().equals(animal.getEspecie().getIdEspecie());
//      assert dto.getNomeEspecie().equals(animal.getEspecie().getNomeEspecie());
        return dto;

    }

}
