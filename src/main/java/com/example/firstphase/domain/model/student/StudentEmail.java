package com.example.firstphase.domain.model.student;

import static org.springframework.util.Assert.isTrue;

public class StudentEmail {

    private final String value;

    public StudentEmail(String value) {
        isTrue(value!= null, "Email cannot be null");
        isTrue(value.matches("^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*$"),
                "Not a valid Email");

        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
