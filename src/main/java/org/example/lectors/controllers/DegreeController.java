package org.example.lectors.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.example.lectors.dtos.DegreeDTO;
import org.example.lectors.services.DegreeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/degrees")
@Builder
public class DegreeController {

    private final DegreeService degreeService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<DegreeDTO> getDegrees(Pageable pageable) {
        return degreeService.findDegrees(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DegreeDTO getDegreeById(@PathVariable long id) {
        return degreeService.getDegreeDTOById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DegreeDTO createDegree(@RequestBody DegreeDTO degreeDTO) {
        return degreeService.saveDegree(degreeDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DegreeDTO updateDegree(
            @PathVariable long id,
            @RequestBody DegreeDTO degreeDTO
    ) {
        return degreeService.updateDegree(id, degreeDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDegree(@PathVariable long id) {
        degreeService.deleteDegreeById(id);
    }

}