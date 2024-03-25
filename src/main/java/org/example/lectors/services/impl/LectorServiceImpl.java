package org.example.lectors.services.impl;


import lombok.Builder;
import org.example.lectors.dtos.LectorDTO;
import org.example.lectors.entities.Lector;
import org.example.lectors.exceptions.NotFoundException;
import org.example.lectors.mappers.LectorMapper;
import org.example.lectors.repositories.LectorRepository;
import org.example.lectors.services.DegreeService;
import org.example.lectors.services.LectorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Builder
public class LectorServiceImpl implements LectorService {

    private final LectorRepository lectorRepository;
    private final LectorMapper lectorMapper;
    private final DegreeService degreeService;


    @Override
    public Page<LectorDTO> findLectors(Pageable pageable) {
        return lectorRepository.findAll(pageable)
                .map(lectorMapper::toLectorDTO);
    }

    @Override
    public Lector findLectorById(long id) {
        return lectorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не удалось найти лектора с id = " + id));
    }

    @Override
    public LectorDTO getLectorDTOById(long id) {
        return lectorMapper.toLectorDTO(findLectorById(id));
    }

    @Override
    public LectorDTO saveLector(LectorDTO lectorDTO) {
        degreeService.findDegreeById(lectorDTO.degreeId());
        Lector savedLector = lectorRepository.save(lectorMapper.toLector(lectorDTO));
        return lectorMapper.toLectorDTO(savedLector);
    }

    @Override
    public LectorDTO updateLector(long id, LectorDTO lectorDTO) {
        degreeService.findDegreeById(lectorDTO.degreeId());
        Lector lector = lectorMapper
                .toLector(lectorDTO)
                .setId(findLectorById(id).getId());
        Lector savedLector = lectorRepository.save(lector);
        return lectorMapper.toLectorDTO(savedLector);
    }

    @Override
    public void deleteLectorById(long id) {
        lectorRepository.deleteById(id);
    }

}