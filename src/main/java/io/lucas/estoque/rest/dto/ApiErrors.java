package io.lucas.estoque.rest.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ApiErrors {
   private Date timestamp;
   private String message;
   private String details;

    public ApiErrors(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
