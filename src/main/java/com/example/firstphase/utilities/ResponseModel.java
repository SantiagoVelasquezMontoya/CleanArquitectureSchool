package com.example.firstphase.utilities;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

public class ResponseModel {

    private int status;

    private String message;

    public ResponseModel(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
