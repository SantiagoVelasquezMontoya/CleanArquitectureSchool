package com.example.firstphase.infrastructure.adapters.jpa.entity.assignature;

import com.example.firstphase.domain.model.assignature.Assignature;
import com.example.firstphase.domain.model.assignature.AssignatureId;
import com.example.firstphase.domain.model.assignature.AssignatureName;
import com.example.firstphase.domain.model.assignature.dto.AssignatureDTO;
import com.example.firstphase.domain.model.student.*;
import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.infrastructure.adapters.jpa.entity.student.StudentDBO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "assignature")
public class AssignatureDBO {

    @Id
    @Column(nullable = true)

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    @OneToMany
    @JsonManagedReference
    private List<StudentDBO> studentDBO;


    public AssignatureDBO(AssignatureDTO assignatureDTO) {
        this.id = assignatureDTO.getId();
        this.name = assignatureDTO.getName();
        if(assignatureDTO.getStudentDTO() != null){
            this.studentDBO = assignatureDTO.getStudentDTO().stream().map(StudentDBO::new).collect(Collectors.toList());
        }
    }

    public AssignatureDBO(Assignature assignature){
        this.id = assignature.getId().getValue();
        this.name = assignature.getName().getValue();
        if(assignature.getStudent() != null){
         this.studentDBO = assignature.getStudent().stream().map(StudentDBO::new).collect(Collectors.toList());
        }
    }

    public static Assignature toAssignature(AssignatureDBO assignatureDBO){
        return new Assignature(
                new AssignatureId(assignatureDBO.getId()),
                new AssignatureName(assignatureDBO.getName()),
                assignatureDBO.getStudentDBO() != null ?
                        assignatureDBO.getStudentDBO().stream().map(StudentDBO::toStudent).collect(Collectors.toList())
                        : new ArrayList<>()
        );
    }
}
