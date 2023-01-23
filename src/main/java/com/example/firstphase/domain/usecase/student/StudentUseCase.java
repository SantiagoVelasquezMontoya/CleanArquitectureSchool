package com.example.firstphase.domain.usecase.student;

import com.example.firstphase.domain.model.gateaways.StudentRepository;
import com.example.firstphase.domain.model.student.Student;
import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.infrastructure.adapters.jpa.entity.student.StudentDBO;

public class StudentUseCase {

    private final StudentRepository studentRepository;


    public StudentUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDBO saveStudent(StudentDTO studentDTO) {
        StudentDBO studentDBO = new StudentDBO(studentRepository.saveStudent(studentDTO));
        return studentDBO;
    }


}
