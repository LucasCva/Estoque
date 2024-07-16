package io.lucas.estoque.rest.controller;


import io.lucas.estoque.exception.RegraNegocioException;
import io.lucas.estoque.rest.dto.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice

public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<ApiErrors> handleRegraNegocioException(RegraNegocioException ex){
        ApiErrors apiErrors = new ApiErrors(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrors);

    }
}
