package org.example.lectors.services.impl;

import lombok.Builder;
import org.example.lectors.dtos.DegreeDTO;
import org.example.lectors.entities.Degree;
import org.example.lectors.exceptions.NotFoundException;
import org.example.lectors.mappers.DegreeMapper;
import org.example.lectors.repositories.DegreeRepository;
import org.example.lectors.services.DegreeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Builder
public class DegreeServiceImpl implements DegreeService {

    private final DegreeRepository degreeRepository;
    private final DegreeMapper degreeMapper;

    @Override
    public Page<DegreeDTO> findDegrees(Pageable pageable) {
        return degreeRepository.findAll(pageable)
                .map(degreeMapper::toDegreeDTO);
    }

    @Override
    public Degree findDegreeById(long id) {
        return degreeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не удалось найти ученую степень с id = " + id));
    }

    @Override
    public DegreeDTO getDegreeDTOById(long id) {
        return degreeMapper.toDegreeDTO(findDegreeById(id));
    }

    @Override
    public DegreeDTO saveDegree(DegreeDTO degreeDTO) {
        Degree savedDegree = degreeRepository.save(degreeMapper.toDegree(degreeDTO));
        return degreeMapper.toDegreeDTO(savedDegree);
    }

    @Override
    public DegreeDTO updateDegree(long id, DegreeDTO degreeDTO) {
        Degree degree = degreeMapper
                .toDegree(degreeDTO)
                .setId(findDegreeById(id).getId());
        Degree savedDegree = degreeRepository.save(degree);
        return degreeMapper.toDegreeDTO(savedDegree);
    }

    @Override
    public void deleteDegreeById(long id) {
        degreeRepository.deleteById(id);
    }

}