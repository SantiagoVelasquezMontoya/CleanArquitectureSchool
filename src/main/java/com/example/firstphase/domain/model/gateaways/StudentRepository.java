package com.example.firstphase.domain.model.gateaways;

import com.example.firstphase.domain.model.student.Student;
import com.example.firstphase.domain.model.student.dto.StudentDTO;

import java.util.List;

public interface StudentRepository {

    public Student saveStudent(Student student);

    public List<Student> getStudents();

    public List<Student> getEnrolledStudents(Integer assignatureId);
    public List<Student> getAllEnrolledStudents();

    public String enrollStudent(Student student);

    public String deleteStudent(Student student);

    public Student getStudent(Integer studentId);
}
