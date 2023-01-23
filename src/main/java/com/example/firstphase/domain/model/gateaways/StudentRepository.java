package com.example.firstphase.domain.model.gateaways;

import com.example.firstphase.domain.model.student.Student;
import com.example.firstphase.domain.model.student.dto.StudentDTO;

public interface StudentRepository {

    public Student saveStudent(StudentDTO studentDTO);
}
