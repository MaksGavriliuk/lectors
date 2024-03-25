package org.example.lectors.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ErrorResponse {
    private String code;
    private String message;
}