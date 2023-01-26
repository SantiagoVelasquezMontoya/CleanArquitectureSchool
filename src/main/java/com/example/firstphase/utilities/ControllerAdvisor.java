package com.example.firstphase.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<ResponseModel> handleException(NoSuchElementException ex){
        return modelResponseBuilder(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<ResponseModel> handleException(IllegalArgumentException ex){
        return modelResponseBuilder(ex, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler
//    private ResponseEntity<String> handle(NullPointerException e){
//        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(e.getMessage());
//    }

    private ResponseEntity<ResponseModel>  modelResponseBuilder
            (Exception ex, HttpStatus status){
        return ResponseEntity.status(status).body(new ResponseModel(status.value(), ex.getMessage()));
    }



}
