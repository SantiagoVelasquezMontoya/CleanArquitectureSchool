package com.example.firstphase.domain.model.student;

import com.example.firstphase.domain.model.assignature.Assignature;

public class Student {

    private final StudentId id;
    private final StudentName name;
    private final StudentPhone phone;
    private final StudentEmail email;

    private Assignature assignature;

    public Student(StudentId id, StudentName name, StudentPhone phone, StudentEmail email, Assignature assignature) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.assignature  = assignature;
    }

    public StudentId getId() {
        return id;
    }

    public StudentName getName() {
        return name;
    }

    public StudentPhone getPhone() {
        return phone;
    }

    public StudentEmail getEmail() {
        return email;
    }

    public Assignature getAssignature() {
        return assignature;
    }
}
