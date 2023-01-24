package com.example.firstphase.domain.model.student.dto;

import com.example.firstphase.domain.model.student.*;
import com.example.firstphase.infrastructure.adapters.jpa.entity.student.StudentDBO;

public class StudentDTO {


    private Long id;

    private String name;
    private Integer phone;

    private String email;

    public StudentDTO(Long id, String name, Integer phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public StudentDTO(Student student){
        this.id = student.getId().getValue();
        this.name = student.getName().getValue();
        this.phone = student.getPhone().getValue();
        this.email = student.getEmail().getValue();
    }

    public StudentDTO(StudentDBO studentDBO){
        this.id = studentDBO.getId();
        this.name = studentDBO.getName();
        this.email = studentDBO.getEmail();
        this.phone = studentDBO.getPhone();
    }

    public static Student toStudent(StudentDTO studentDTO){
        return new Student(
                new StudentId(studentDTO.getId()),
                new StudentName(studentDTO.getName()),
                new StudentPhone(studentDTO.getPhone()),
                new StudentEmail(studentDTO.getEmail())
        );
    }

    public StudentDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
