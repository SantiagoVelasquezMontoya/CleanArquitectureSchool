package com.example.firstphase.infrastructure.adapters.jpa.adapters.student;

import com.example.firstphase.domain.model.gateaways.StudentRepository;
import com.example.firstphase.domain.model.student.Student;
import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.infrastructure.adapters.jpa.adapters.assignature.AssignatureAdapterRepository;
import com.example.firstphase.infrastructure.adapters.jpa.entity.assignature.AssignatureDBO;
import com.example.firstphase.infrastructure.adapters.jpa.entity.student.StudentDBO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class StudentRepositoryAdapter implements StudentRepository {

    public final StudentAdapterRepository studentAdapterRepository;
    private final AssignatureAdapterRepository assignatureAdapterRepository;

    public StudentRepositoryAdapter(StudentAdapterRepository studentAdapterRepository,
                                    AssignatureAdapterRepository assignatureAdapterRepository) {
        this.studentAdapterRepository = studentAdapterRepository;
        this.assignatureAdapterRepository = assignatureAdapterRepository;
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
        Optional<StudentDBO> foundStudent = studentAdapterRepository.findById(Math.toIntExact(studentDTO.getId()));
        Optional<AssignatureDBO> foundAssignature = assignatureAdapterRepository
                .findById(Math.toIntExact(studentDTO.getAssignatureDTO().getId()));
        if(foundAssignature.isEmpty()) return "This Assignature Doesn't Exist";
        if(foundStudent.isEmpty()) return "This Student Doesn't Exist";
        Optional<StudentDBO> savedStudent = Optional.of(studentAdapterRepository.save(new StudentDBO(studentDTO)));
        return "Student was enrolled";
    }


    @Override
    public List<Student> getEnrolledStudents(Integer assignatureId) {
        List<StudentDBO> studentDBOList = (List<StudentDBO>) studentAdapterRepository.findByAssignatureDBO_Id(assignatureId);
        return studentDBOList.stream().map(StudentDBO::toStudent).collect(Collectors.toList());
    }
}
