package com.example.firstphase.domain.model.gateaways;

import com.example.firstphase.domain.model.student.Student;
import com.example.firstphase.domain.model.student.dto.StudentDTO;

import java.util.List;

public interface StudentRepository {

    public Student saveStudent(StudentDTO studentDTO);

    public List<Student> getStudents();
}
