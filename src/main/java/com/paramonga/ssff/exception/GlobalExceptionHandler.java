package com.paramonga.ssff.exception;

import com.paramonga.ssff.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Manejo de excepciones de argumentos inválidos
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
        ApiResponse<Object> response = new ApiResponse<>(
                HttpStatus.BAD_REQUEST.value(),   // status 400
                ex.getMessage(),
                null,
                null
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // Manejador para excepciones específicas (por ejemplo, una ResourceNotFoundException)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFound(ResourceNotFoundException ex) {
        ApiResponse<Object> response = new ApiResponse<>(
                HttpStatus.NOT_FOUND.value(),   // status 404
                ex.getMessage(),
                null,
                null
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // Manejador genérico para cualquier otra excepción
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneralException(Exception ex) {
        ApiResponse<Object> response = new ApiResponse<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),  // status 500
                "Internal server error: " + ex.getMessage(),
                null,
                null
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
