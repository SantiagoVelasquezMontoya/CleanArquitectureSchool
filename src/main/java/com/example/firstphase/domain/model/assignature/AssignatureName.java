package com.example.firstphase.domain.model.assignature;

import static org.springframework.util.Assert.isTrue;

public class AssignatureName {

    private final String value;


    public AssignatureName(String value) {
        isTrue(value.matches("^[aA-zZ]+"),"Name can only have Letters");
        isTrue(value.length() <= 15,"Name must have a maximum of 15 characters" );
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
