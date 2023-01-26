package com.example.firstphase.infrastructure.adapters.jpa.adapters;


import com.example.firstphase.domain.model.assignature.Assignature;
import com.example.firstphase.domain.model.assignature.AssignatureId;
import com.example.firstphase.domain.model.assignature.AssignatureName;
import com.example.firstphase.domain.model.student.*;
import com.example.firstphase.infrastructure.adapters.jpa.adapters.assignature.AssignatureAdapterRepository;
import com.example.firstphase.infrastructure.adapters.jpa.adapters.assignature.AssignatureRepositoryAdapter;
import com.example.firstphase.infrastructure.adapters.jpa.adapters.student.StudentAdapterRepository;
import com.example.firstphase.infrastructure.adapters.jpa.adapters.student.StudentRepositoryAdapter;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Array;
import java.util.ArrayList;

@DataJpaTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentAdapterRepositoryTest {

    @Autowired
    private StudentAdapterRepository studentRepo;

    @Autowired
    private AssignatureAdapterRepository assignatureRepo;


    @InjectMocks
    private StudentRepositoryAdapter  studentRepositoryAdapter;

    @InjectMocks
    private AssignatureRepositoryAdapter assignatureRepositoryAdapter;

    @BeforeAll
    void init(){
        studentRepositoryAdapter =
                new StudentRepositoryAdapter(studentRepo, assignatureRepo);

        assignatureRepositoryAdapter =
                new AssignatureRepositoryAdapter(assignatureRepo);
    }


    @Test
    @DisplayName("Save Student Test OK")
    void saveStudent(){

        //Arrange
        Assignature assignature = new Assignature(
                new AssignatureId(1L),
                new AssignatureName("Programing"),
                new ArrayList<>());

        Student student = new
                Student(
                new StudentId(1L),
                new StudentName("Santiago"),
                new StudentPhone(123),
                new StudentEmail("santiago@gmail.com"), assignature);

        //Action
        assignatureRepositoryAdapter.saveAssignature(assignature);
        Student res = studentRepositoryAdapter.saveStudent(student);

        //Assert
        Assertions.assertEquals(student.getName().getValue(), res.getName().getValue());
    }

    @Test
    @DisplayName("Find Student By Id OK")
    void findStudentById(){
        //Arrange
        Assignature assignature = new Assignature(
                new AssignatureId(1L),
                new AssignatureName("Programing"),
                new ArrayList<>());

        Student student = new
                Student(
                new StudentId(1L),
                new StudentName("Santiago"),
                new StudentPhone(123),
                new StudentEmail("santiago@gmail.com"), assignature);

        Integer studentId = Math.toIntExact(student.getId().getValue());

        //Actions
        assignatureRepositoryAdapter.saveAssignature(assignature);
        studentRepositoryAdapter.enrollStudent(student);
        Student res = studentRepositoryAdapter.getStudent(studentId);

        //Asserts
        Assertions.assertEquals(student.getName().getValue(), res.getName().getValue());
    }




}
