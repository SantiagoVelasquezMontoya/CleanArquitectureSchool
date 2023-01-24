package com.example.firstphase.domain.usecase.student;

import com.example.firstphase.domain.model.gateaways.StudentRepository;
import com.example.firstphase.domain.model.student.Student;
import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.infrastructure.adapters.jpa.entity.student.StudentDBO;

import java.util.List;
import java.util.stream.Collectors;

public class StudentUseCase {

    private final StudentRepository studentRepository;


    public StudentUseCase(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDBO saveStudent(StudentDTO studentDTO) {
        StudentDBO studentDBO = new StudentDBO(studentRepository.saveStudent(studentDTO));
        return studentDBO;
    }

    public List<StudentDTO> getStudents(){
        List<StudentDTO> studentDTOList = studentRepository.getStudents().stream().map(StudentDTO::new).collect(Collectors.toList());
        return studentDTOList;
    }

    public String enrollStudent(StudentDTO studentDTO){
        studentRepository.enrollStudent(studentDTO);
        return "Sending Student";
    }


}
