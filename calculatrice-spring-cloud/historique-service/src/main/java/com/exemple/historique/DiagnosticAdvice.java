package com.exemple.historique;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class DiagnosticAdvice {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> illisible(HttpMessageNotReadableException e) {
        Throwable cause = NestedExceptionUtils.getMostSpecificCause(e);
        System.out.println("[DIAGNOSTIC] " + cause);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("cause", String.valueOf(cause.getMessage())));
    }
}