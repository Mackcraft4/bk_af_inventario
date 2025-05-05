package com.paramonga.ssff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private Integer status;    // Ej.: "success" o "error"
    private String message;   // Mensaje descriptivo
    private T data;           // Carga útil (puede ser DTO, lista, etc.)
    private Object metadata;  // Información adicional (p. ej., timestamp, paginación, etc.)
}
