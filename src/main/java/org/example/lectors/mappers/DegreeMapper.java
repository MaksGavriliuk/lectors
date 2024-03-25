package org.example.lectors.mappers;


import org.example.lectors.dtos.DegreeDTO;
import org.example.lectors.entities.Degree;
import org.mapstruct.Mapper;


@Mapper
public interface DegreeMapper {

    Degree toDegree(DegreeDTO degreeDTO);

    DegreeDTO toDegreeDTO(Degree degree);

}