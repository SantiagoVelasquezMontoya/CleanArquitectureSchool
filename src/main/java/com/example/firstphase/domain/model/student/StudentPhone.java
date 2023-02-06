package com.example.firstphase.domain.model.student;
import static org.springframework.util.Assert.isTrue;

public class StudentPhone {

    private final Integer value;

    public StudentPhone(Integer value) {
        isTrue(value.toString().matches("^[0-9]+") , "Only numbers on Phone Number");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
