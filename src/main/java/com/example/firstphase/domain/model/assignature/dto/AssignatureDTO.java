package com.example.firstphase.domain.model.assignature.dto;

import com.example.firstphase.domain.model.assignature.Assignature;
import com.example.firstphase.domain.model.assignature.AssignatureId;
import com.example.firstphase.domain.model.assignature.AssignatureName;
import com.example.firstphase.domain.model.student.*;
import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.infrastructure.adapters.jpa.entity.assignature.AssignatureDBO;
import com.example.firstphase.infrastructure.adapters.jpa.entity.student.StudentDBO;

public class AssignatureDTO {
    private Long id;
    private String name;

    public AssignatureDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public AssignatureDTO(AssignatureDBO assignatureDBO){
        this.id = assignatureDBO.getId();
        this.name = assignatureDBO.getName();
    }

    public static Assignature toAssignature(AssignatureDTO assignatureDTO){
        return new Assignature(
                new AssignatureId(assignatureDTO.getId()),
                new AssignatureName(assignatureDTO.getName())
        );
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
}
