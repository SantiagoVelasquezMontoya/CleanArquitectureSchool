package com.example.firstphase.domain.model.assignature;

import com.example.firstphase.domain.model.student.Student;
import com.example.firstphase.domain.model.student.dto.StudentDTO;

import java.util.List;

public class Assignature {
    private final AssignatureId id;
    private final AssignatureName name;

    private final List<AssignatureStudent> student;

    public Assignature(AssignatureId id, AssignatureName name, List<AssignatureStudent> student) {
        this.id = id;
        this.name = name;
        this.student = student;
    }

    public AssignatureId getId() {
        return id;
    }

    public AssignatureName getName() {
        return name;
    }

    public List<AssignatureStudent> getStudent() {
        return student;
    }
}
