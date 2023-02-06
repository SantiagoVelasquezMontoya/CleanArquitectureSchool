package com.example.firstphase.domain.model.student;
import static org.springframework.util.Assert.isTrue;

public class StudentName {

    private final String value;

    public StudentName(String value) {
        isTrue(value.matches("^[aA-zZ]+"),"Name can only have Letters");
        isTrue(value.length() <= 15,"Name must have a maximum of 15 characters" );
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
