package org.example.lectors.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.example.lectors.dtos.LectorDTO;
import org.example.lectors.services.LectorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lectors")
@Builder
public class LectorController {

    private final LectorService lectorService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<LectorDTO> getLectors(Pageable pageable) {
        return lectorService.findLectors(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LectorDTO getLectorById(@PathVariable long id) {
        return lectorService.getLectorDTOById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LectorDTO createLector(@RequestBody LectorDTO lectorDTO) {
        return lectorService.saveLector(lectorDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LectorDTO updateLector(
            @PathVariable long id,
            @RequestBody LectorDTO lectorDTO
    ) {
        return lectorService.updateLector(id, lectorDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLector(@PathVariable long id) {
        lectorService.deleteLectorById(id);
    }

}