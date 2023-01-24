package com.example.firstphase.infrastructure.adapters.jpa.entity.student;

import com.example.firstphase.domain.model.student.*;
import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.infrastructure.adapters.jpa.entity.assignature.AssignatureDBO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name ="students")
public class StudentDBO {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Integer phone;

    @ManyToOne
    @JoinColumn(name = "assignature_dbo_id")
    private AssignatureDBO assignatureDBO;




//    public StudentDBO(Long id, String name, String email, Integer phone, AssignatureDBO assignatureDBO) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.phone = phone;
//        this.assignatureDBO = assignatureDBO;
//    }

    public StudentDBO(Student student){
        this.id = student.getId().getValue();
        this.name = student.getName().getValue();
        this.phone = student.getPhone().getValue();
        this.email = student.getEmail().getValue();
    }

    public StudentDBO(StudentDTO studentDTO){
        this.id = studentDTO.getId();
        this.name = studentDTO.getName();
        this.email = studentDTO.getEmail();
        this.assignatureDBO = new AssignatureDBO(studentDTO.getAssignatureDTO());
    }

    public static Student toStudent(StudentDBO studentDBO){
        return new Student(
                new StudentId(studentDBO.getId()),
                new StudentName(studentDBO.getName()),
                new StudentPhone(studentDBO.getPhone()),
                new StudentEmail(studentDBO.getEmail()),
                AssignatureDBO.toAssignature(studentDBO.getAssignatureDBO())
        );
    }

}
