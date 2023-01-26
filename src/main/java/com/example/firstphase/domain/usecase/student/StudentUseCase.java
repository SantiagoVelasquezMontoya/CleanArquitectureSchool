package com.example.firstphase.domain.usecase.student;

import com.example.firstphase.domain.model.gateaways.StudentRepository;
import com.example.firstphase.domain.model.student.Student;
import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.infrastructure.adapters.jpa.entity.student.StudentDBO;
import com.example.firstphase.utilities.ValidationFilter;

import java.util.List;
import java.util.stream.Collectors;

public class StudentUseCase {

    private final StudentRepository studentRepository;
    private final ValidationFilter validationFilter;

    public StudentUseCase(StudentRepository studentRepository, ValidationFilter validationFilter) {
        this.studentRepository = studentRepository;
        this.validationFilter = validationFilter;
    }

    public StudentDTO saveStudent(StudentDTO studentDTO) {
        StudentDBO studentDBO = new StudentDBO(studentRepository.saveStudent(StudentDTO.toStudent(studentDTO)));
        return new StudentDTO(studentDBO);
    }

    public List<StudentDTO> getStudents(){
        List<StudentDTO> studentDTOList = studentRepository.getStudents().stream().map(StudentDTO::new).collect(Collectors.toList());
        return studentDTOList;
    }

    public String enrollStudent(StudentDTO studentDTO){

        return studentRepository.enrollStudent(StudentDTO.toStudent(studentDTO));
    }

    public List<StudentDTO> getEnrolledStudents(Integer assignatureId){
        return studentRepository.getEnrolledStudents(assignatureId).stream().map(StudentDTO::new).collect(Collectors.toList());
    }

    public String deleteStudent(StudentDTO studentDTO){
        return studentRepository.deleteStudent(StudentDTO.toStudent(studentDTO));
    }

    public StudentDTO getStudent(Integer studentid){
        return new StudentDTO(studentRepository.getStudent(studentid));
    }

    public List<StudentDTO> getAllEnrolledStudents(){
        return studentRepository.getAllEnrolledStudents()
                .stream().map(StudentDTO::new).collect(Collectors.toList());
    }

}
