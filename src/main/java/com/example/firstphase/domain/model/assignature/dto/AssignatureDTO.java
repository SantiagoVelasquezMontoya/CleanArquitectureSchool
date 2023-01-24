package com.example.firstphase.domain.model.assignature.dto;

import com.example.firstphase.domain.model.assignature.Assignature;
import com.example.firstphase.domain.model.assignature.AssignatureId;
import com.example.firstphase.domain.model.assignature.AssignatureName;
import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.infrastructure.adapters.jpa.entity.assignature.AssignatureDBO;

import java.util.List;
import java.util.stream.Collectors;

public class AssignatureDTO {
    private Long id;
    private String name;

    private List<StudentDTO> studentDTO;

    public AssignatureDTO(Long id, String name, List<StudentDTO> studentDTO) {
        this.id = id;
        this.name = name;
        this.studentDTO = studentDTO;
    }

    public AssignatureDTO(AssignatureDBO assignatureDBO){
        this.id = assignatureDBO.getId();
        this.name = assignatureDBO.getName();
        this.studentDTO = assignatureDBO.getStudentDBO().stream().map(StudentDTO::new).collect(Collectors.toList());
    }

    public static Assignature toAssignature(AssignatureDTO assignatureDTO){
        return new Assignature(
                new AssignatureId(assignatureDTO.getId()),
                new AssignatureName(assignatureDTO.getName()),
                assignatureDTO.studentDTO.stream().map(StudentDTO::toStudent).collect(Collectors.toList())
                );
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
