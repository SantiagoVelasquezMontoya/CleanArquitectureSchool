package com.example.firstphase.domain.model.assignature;

import com.example.firstphase.domain.model.student.Student;

import java.util.List;

public class AssignatureStudent {

    private final List<Student> value;

    public AssignatureStudent(List<Student> value) {
        this.value = value;
    }

    public List<Student> getValue() {
        return value;
    }
}
