package com.example.firstphase.domain.model.assignature.dto;

import com.example.firstphase.domain.model.assignature.Assignature;
import com.example.firstphase.domain.model.assignature.AssignatureId;
import com.example.firstphase.domain.model.assignature.AssignatureName;
import com.example.firstphase.domain.model.student.*;
import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.infrastructure.adapters.jpa.entity.student.StudentDBO;

public class AssignatureDTO {
    private Integer id;
    private String name;

    public AssignatureDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

//    public StudentDTO(StudentDBO studentDBO){
//        this.id = studentDBO.getId();
//        this.name = studentDBO.getName();
//        this.email = studentDBO.getEmail();
//        this.phone = studentDBO.getPhone();
//    }

    public static Assignature toAssignature(AssignatureDTO assignatureDTO){
        return new Assignature(
                new AssignatureId(assignatureDTO.getId()),
                new AssignatureName(assignatureDTO.getName())
        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
