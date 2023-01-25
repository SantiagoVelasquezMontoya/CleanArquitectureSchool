package com.example.firstphase.domain.model.assignature.dto;

import com.example.firstphase.domain.model.assignature.Assignature;
import com.example.firstphase.domain.model.assignature.AssignatureId;
import com.example.firstphase.domain.model.assignature.AssignatureName;
import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.infrastructure.adapters.jpa.entity.assignature.AssignatureDBO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.stream.Collectors;

public class AssignatureDTO {
    private Long id;
    private String name;

    @JsonIgnore
    private List<StudentDTO> studentDTO;

    public AssignatureDTO(Long id, String name, List<StudentDTO> studentDTO) {
        this.id = id;
        this.name = name;
        this.studentDTO = studentDTO;
    }

    public AssignatureDTO(AssignatureDBO assignatureDBO){
        this.id = assignatureDBO.getId();
        this.name = assignatureDBO.getName();
        if(assignatureDBO.getStudentDBO() != null){
            this.studentDTO = assignatureDBO.getStudentDBO().stream().map(StudentDTO::new).collect(Collectors.toList());
        }
    }

    public static Assignature toAssignature(AssignatureDTO assignatureDTO){
        if(assignatureDTO != null){
        return new Assignature(
                new AssignatureId(assignatureDTO.getId()),
                new AssignatureName(assignatureDTO.getName()),
                 assignatureDTO.getStudentDTO() != null ?
                     assignatureDTO.getStudentDTO().stream().map(StudentDTO::toStudent).collect(Collectors.toList())
                         : null
                );
        } else{
        return null;        }
    }


    //Testing Constructor below
    public AssignatureDTO(Assignature assignature){
        this.id = assignature.getId().getValue();
        this.name = assignature.getName().getValue();
        if(assignature.getStudent() != null){
            this.studentDTO = assignature.getStudent().stream().map(StudentDTO::new).collect(Collectors.toList());
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<StudentDTO> getStudentDTO() {
        return studentDTO;
    }
}
