package org.example.lectors.services;

import org.example.lectors.dtos.DegreeDTO;
import org.example.lectors.entities.Degree;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DegreeService {

    Page<DegreeDTO> findDegrees(Pageable pageable);

    Degree findDegreeById(long id);

    DegreeDTO getDegreeDTOById(long id);

    void deleteDegreeById(long id);

    DegreeDTO saveDegree(DegreeDTO degreeDTO);

    DegreeDTO updateDegree(long id, DegreeDTO degreeDTO);

}