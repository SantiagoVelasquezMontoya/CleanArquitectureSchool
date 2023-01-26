package com.example.firstphase.infrastructure.adapters.jpa.adapters;

import com.example.firstphase.domain.model.assignature.Assignature;
import com.example.firstphase.domain.model.assignature.AssignatureId;
import com.example.firstphase.domain.model.assignature.AssignatureName;
import com.example.firstphase.domain.model.student.Student;
import com.example.firstphase.infrastructure.adapters.jpa.adapters.assignature.AssignatureAdapterRepository;
import com.example.firstphase.infrastructure.adapters.jpa.adapters.assignature.AssignatureRepositoryAdapter;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

@DataJpaTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AssignatureAdapterRepositoryTest {
    @Autowired
    private AssignatureAdapterRepository repo;

    @InjectMocks
    private AssignatureRepositoryAdapter assignatureRepositoryAdapter;

    @BeforeAll
      void init(){
        assignatureRepositoryAdapter =
                new AssignatureRepositoryAdapter(repo);
    }
    @Test
    @Order(1)
    @DisplayName("Save Assignature Success")
    public void saveAssignature(){

        //Arrange
        Assignature assignature =
                new Assignature(new AssignatureId(1L), new AssignatureName("Python"),
                        new ArrayList<>());

        //Action
        Assignature res = assignatureRepositoryAdapter.saveAssignature(assignature);

        //Assert
        Assertions.assertEquals("Python" ,res.getName().getValue());
    }



    @Test
    @Order(2)
    @DisplayName("Get Assignature by Id")
    void getAssignature(){
        Integer inputId = 1;

        Assignature assignature =
                new Assignature
                        (new AssignatureId(1L), new AssignatureName("Python"), new ArrayList<>());

        Assignature res =  assignatureRepositoryAdapter.getAssignature(inputId);
        Assertions.assertEquals("This assignature does not exist", res);
    }















}
