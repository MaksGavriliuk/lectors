package org.example.lectors.services;

import org.example.lectors.dtos.LectorDTO;
import org.example.lectors.entities.Lector;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface LectorService {

    Page<LectorDTO> findLectors(Pageable pageable);

    Lector findLectorById(long id);

    LectorDTO getLectorDTOById(long id);

    void deleteLectorById(long id);

    LectorDTO saveLector(LectorDTO lectorDTO);

    LectorDTO updateLector(long id, LectorDTO lectorDTO);

}