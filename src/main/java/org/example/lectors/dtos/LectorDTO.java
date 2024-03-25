package org.example.lectors.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public record LectorDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) @NotNull Long id,
        @NotBlank String surname,
        @NotBlank String name,
        @NotBlank String patronymic,
        @Positive @Max(100) @NotNull Integer experience,
        @NotNull Long degreeId
) {
}