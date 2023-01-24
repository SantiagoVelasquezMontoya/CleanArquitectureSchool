package com.example.firstphase.domain.model.gateaways;

import com.example.firstphase.domain.model.student.Student;
import com.example.firstphase.domain.model.student.dto.StudentDTO;

import java.util.List;

public interface StudentRepository {

    public Student saveStudent(StudentDTO studentDTO);

    public List<Student> getStudents();

    public List<Student> getEnrolledStudents(Integer assignatureId);

    public String enrollStudent(StudentDTO studentDTO);
}
