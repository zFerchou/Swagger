package org.example.config.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class FieldsControllerValidations {

    // Maneja excepciones de validación de campos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        // Recoger los errores de validación de los campos
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            // Agregar el nombre del campo y el mensaje de error
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        // Log para que los errores de validación sean visibles
        log.error("Error en la validación de campos: {}", errors);

        // Crear una respuesta personalizada
        Map<String, Object> response = new HashMap<>();
        response.put("estado", "FIRMA_INVALIDA");
        response.put("mensaje", "Error en la validación de los campos");
        response.put("errores", errors);

        // Devolver una respuesta con un código 400 (Bad Request)
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Puedes manejar otras excepciones si es necesario
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralExceptions(Exception ex) {
        log.error("Se produjo un error inesperado: ", ex);

        Map<String, Object> response = new HashMap<>();
        response.put("estado", "ERROR_INESPERADO");
        response.put("mensaje", "Ocurrió un error inesperado en el sistema");

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
