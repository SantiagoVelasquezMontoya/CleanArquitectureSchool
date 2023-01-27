package com.example.firstphase.domain.model.student;

import org.springframework.util.Assert;

public class StudentId {

    private final Long value;


    public StudentId(Long value) {
       // Assert.isTrue(value != null , "Id must not be null");
       // Assert.isTrue(value.toString().matches("^[0-9]+") , "Id can only have Numbers");
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
