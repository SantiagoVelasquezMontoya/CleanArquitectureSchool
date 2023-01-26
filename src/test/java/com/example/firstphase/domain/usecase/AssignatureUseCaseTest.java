package com.example.firstphase.domain.usecase;


import com.example.firstphase.domain.model.assignature.Assignature;
import com.example.firstphase.domain.model.assignature.dto.AssignatureDTO;
import com.example.firstphase.domain.model.gateaways.AssignatureRepository;
import com.example.firstphase.domain.usecase.assignature.AssignatureUseCase;
import com.example.firstphase.infrastructure.adapters.jpa.entity.assignature.AssignatureDBO;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AssignatureUseCaseTest {


    @Mock
    private AssignatureRepository assignatureRepository;

    @InjectMocks
    private AssignatureUseCase assignatureUseCase;

    @Test
    @Order(1)
    void saveAssignature(){
        AssignatureDTO assignatureDTO = new AssignatureDTO
                                        (1L, "Python");

        Assignature assignature = AssignatureDTO.toAssignature(assignatureDTO);

        when(assignatureRepository.saveAssignature(any(Assignature.class)))
                .thenReturn(assignature);

        AssignatureDTO res  = assignatureUseCase.saveAssignature(assignatureDTO);
        Assertions.assertEquals(assignatureDTO.getName(), res.getName());
    }

    @Test
    @Order(2)
    void getAssignature(){
        Integer inputId = 1;

        AssignatureDTO assignatureDTO = new AssignatureDTO
                (1L, "Python");

        Assignature assignature = AssignatureDTO.toAssignature(assignatureDTO);

        when(assignatureRepository.getAssignature(any(Integer.class)))
                .thenReturn(assignature);

        AssignatureDTO res = assignatureUseCase.getAssignature(inputId);
        Assertions.assertEquals(assignatureDTO.getName(), res.getName());
    }
}


