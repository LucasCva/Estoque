package io.lucas.estoque.rest.controller;


import io.lucas.estoque.exception.NotFoundException;
import io.lucas.estoque.exception.RegraNegocioException;
import io.lucas.estoque.rest.dto.ApiErrors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice

public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<ApiErrors> handleRegraNegocioException(RegraNegocioException ex){
        ApiErrors apiErrors = new ApiErrors(new Date(), ex.getMessage(), "Regra de negócio error");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrors);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrors> handleNotFoundExceptiom(NotFoundException ex){
        ApiErrors apiErrors = new ApiErrors(new Date(), ex.getMessage(), "Not found error");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiErrors);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, String> erros = ex.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(
                FieldError::getField,
                DefaultMessageSourceResolvable::getDefaultMessage
        ));
        ApiErrors apiErrors = new ApiErrors(new Date(), "Argumentos não válidos", erros.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrors);
    }


}
