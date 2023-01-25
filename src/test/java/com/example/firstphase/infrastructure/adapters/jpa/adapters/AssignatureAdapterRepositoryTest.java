package com.example.firstphase.infrastructure.adapters.jpa.adapters;

import com.example.firstphase.domain.model.assignature.Assignature;
import com.example.firstphase.infrastructure.adapters.jpa.adapters.assignature.AssignatureAdapterRepository;
import com.example.firstphase.infrastructure.adapters.jpa.adapters.assignature.AssignatureRepositoryAdapter;
import com.example.firstphase.infrastructure.adapters.jpa.entity.assignature.AssignatureDBO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.util.ArrayList;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@DataJpaTest
@ActiveProfiles("test")
public class AssignatureAdapterRepositoryTest {

    @MockBean
    private AssignatureAdapterRepository assignatureAdapterRepository;
    @Autowired
    private AssignatureRepositoryAdapter assignatureRepositoryAdapter;

    @BeforeAll
     static void init(){


    }
    @Test
    @DisplayName("Save Assignature Success")
    public void saveAssignature(){
        //Arrange
        AssignatureDBO assignatureDBO = new AssignatureDBO
                (1L,"Mate", new ArrayList<>());

        Assignature assignature = AssignatureDBO
                .toAssignature(assignatureDBO);

        Mockito.when(assignatureAdapterRepository.save
                (Mockito.any(AssignatureDBO.class)))
            .thenReturn(assignatureDBO);

        //Actions
        Assignature res = assignatureRepositoryAdapter
                .saveAssignature(AssignatureDBO.toAssignature(assignatureDBO));

        //Assert
            assertTrue("This does MAtcb",res.getName().getValue()
                    .equals(assignatureDBO.getName()));



    }
}
