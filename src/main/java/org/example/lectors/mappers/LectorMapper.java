package org.example.lectors.mappers;


import org.example.lectors.dtos.LectorDTO;
import org.example.lectors.entities.Lector;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface LectorMapper {

    @Mapping(source = "degreeId", target = "degree.id")
    Lector toLector(LectorDTO lectorDTO);

    @Mapping(source = "degree.id", target = "degreeId")
    LectorDTO toLectorDTO(Lector lector);

}