package com.example.firstphase.infrastructure.adapters.jpa.utilities;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.NotDirectoryException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableWebMvc
@ControllerAdvice
public class Adviser extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ResponseModel> handleIllegalArgumentException(IllegalArgumentException ex){


        HttpStatus status = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ResponseModel(status.value(), ex.getMessage()), status);
    }

    @ExceptionHandler
    public ResponseEntity<ResponseModel> handleIllegalArgumentException(Exception ex){

        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ResponseModel(status.value(), ex.getMessage()), status);
    }



}


