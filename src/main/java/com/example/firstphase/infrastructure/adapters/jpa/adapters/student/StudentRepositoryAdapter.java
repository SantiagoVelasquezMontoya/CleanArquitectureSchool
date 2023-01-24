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
    public Student saveStudent(Student student) {
        return StudentDBO.toStudent(studentAdapterRepository.save(new StudentDBO(student)));
    }

    @Override
    public List<Student> getStudents() {
        List<StudentDBO> studentDBOList = (List<StudentDBO>) studentAdapterRepository.findAll();
        return studentDBOList.stream().map(StudentDBO::toStudent).collect(Collectors.toList());
    }

    @Override
    public String enrollStudent(Student student) {
//        Optional<StudentDBO> foundStudent = studentAdapterRepository.
//                findById(Math.toIntExact(student.getId().getValue()));
//        Optional<AssignatureDBO> foundAssignature = assignatureAdapterRepository
//                .findById(Math.toIntExact(student.getAssignature().getId().getValue()));
//        //if(foundStudent.isEmpty()) return "This Student Doesn't Exist";
//        if(foundAssignature.isEmpty()) return "This Assignature Doesn't Exist";
//        Optional<StudentDBO> savedStudent = Optional.of(studentAdapterRepository.save(new StudentDBO(student)));
//        return "Student was enrolled";
        Optional<AssignatureDBO> foundAssignature = assignatureAdapterRepository.
                findById(Math.toIntExact(student.getAssignature().getId().getValue()));
        if(foundAssignature.isEmpty()){
         return "This Assignature does not exist";
        }
        studentAdapterRepository.save(new StudentDBO(student));
        return "The student was saved and enrolled in the assignature successfully.";

    }

    @Override
    public List<Student> getEnrolledStudents(Integer assignatureId) {
        List<StudentDBO> studentDBOList = (List<StudentDBO>) studentAdapterRepository.findByAssignatureDBO_Id(assignatureId);
        return studentDBOList.stream().map(StudentDBO::toStudent).collect(Collectors.toList());
    }

    @Override
    public String deleteStudent(Student student) {
        Optional<StudentDBO> foundStudent = studentAdapterRepository.
                findById(Math.toIntExact(student.getId().getValue()));
        if(foundStudent.isEmpty()) return "This Student Doesn't Exist";
        studentAdapterRepository.delete(foundStudent.get());
        return "The Student Was Succesfully Deleted";
    }

    @Override
    public Student getStudent(Integer studentId) {
        Optional<StudentDBO> foundStudent = studentAdapterRepository.
                findById(Math.toIntExact(studentId));
        return foundStudent.map(StudentDBO::toStudent).orElse(null);
    }

    @Override
    public List<Student> getAllEnrolledStudents() {
        List<StudentDBO> studentDBOList = (List<StudentDBO>) studentAdapterRepository.findAll();
        return  studentDBOList.stream().filter(student -> {
            return student.getAssignatureDBO() != null;
        }).map(StudentDBO::toStudent).collect(Collectors.toList());
    }
}
