package com.example.firstphase.infrastructure.adapters.jpa.entity.assignature;

import com.example.firstphase.domain.model.assignature.Assignature;
import com.example.firstphase.domain.model.assignature.AssignatureId;
import com.example.firstphase.domain.model.assignature.AssignatureName;
import com.example.firstphase.domain.model.assignature.dto.AssignatureDTO;
import com.example.firstphase.domain.model.student.*;
import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.infrastructure.adapters.jpa.entity.student.StudentDBO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "assignature")
public class AssignatureDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    public AssignatureDBO(AssignatureDTO assignatureDTO) {
        this.id = assignatureDTO.getId();
        this.name = assignatureDTO.getName();
    }

    public AssignatureDBO(Assignature assignature){
        this.id = assignature.getId().getValue();
        this.name = assignature.getName().getValue();
    }

    public static Assignature toAssignature(AssignatureDBO assignatureDBO){
        return new Assignature(
                new AssignatureId(assignatureDBO.getId()),
                new AssignatureName(assignatureDBO.getName())
        );
    }
}
