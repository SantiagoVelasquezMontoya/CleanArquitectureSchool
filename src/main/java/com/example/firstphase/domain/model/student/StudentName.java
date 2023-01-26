package com.example.firstphase.domain.model.student;
import static org.springframework.util.Assert.isTrue;

public class StudentName {

    private final String value;

    public StudentName(String value) {
        isTrue(value.matches("^[aA-zZ]+") , value = "Name can only have Letters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
