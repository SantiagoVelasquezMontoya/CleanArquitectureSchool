package com.example.firstphase.infrastructure.adapters.jpa.adapters.student;

import com.example.firstphase.domain.model.gateaways.StudentRepository;
import com.example.firstphase.domain.model.student.Student;
import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.infrastructure.adapters.jpa.entity.student.StudentDBO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


@Repository
public class StudentRepositoryAdapter implements StudentRepository {

    public final StudentAdapterRepository studentAdapterRepository;

    public StudentRepositoryAdapter(StudentAdapterRepository studentAdapterRepository) {
        this.studentAdapterRepository = studentAdapterRepository;
    }

    @Override
    public Student saveStudent(StudentDTO studentDTO) {
        return StudentDBO.toStudent(studentAdapterRepository.save(new StudentDBO(studentDTO)));
    }

    @Override
    public List<Student> getStudents() {
        List<StudentDBO> studentDBOList = (List<StudentDBO>) studentAdapterRepository.findAll();
        return studentDBOList.stream().map(StudentDBO::toStudent).collect(Collectors.toList());
    }

    @Override
    public String enrollStudent(StudentDTO studentDTO) {
        StudentDBO savedStudent = studentAdapterRepository.save(new StudentDBO(studentDTO));
        return "Student was enrolled";
    }


}
