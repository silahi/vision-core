package com.alhous.vision.visioncore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MembreNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(MembreNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String advice(MembreNotFoundException ex) {
        return ex.getMessage();
    }
}
