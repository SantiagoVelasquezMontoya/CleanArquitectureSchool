package com.example.firstphase.infrastructure.adapters.jpa.adapters.student;

import com.example.firstphase.domain.model.gateaways.StudentRepository;
import com.example.firstphase.domain.model.student.Student;
import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.infrastructure.adapters.jpa.entity.student.StudentDBO;
import org.springframework.stereotype.Repository;


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
}
