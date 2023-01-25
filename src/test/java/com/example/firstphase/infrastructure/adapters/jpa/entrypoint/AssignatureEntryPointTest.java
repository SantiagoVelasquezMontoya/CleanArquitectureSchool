package com.example.firstphase.infrastructure.adapters.jpa.entrypoint;


import com.example.firstphase.domain.model.assignature.dto.AssignatureDTO;
import com.example.firstphase.domain.usecase.assignature.AssignatureUseCase;
import com.example.firstphase.infrastructure.adapters.jpa.entity.assignature.AssignatureDBO;
import com.example.firstphase.infrastructure.adapters.jpa.entrypoint.AssignatureEntryPoint;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultHandlersDsl;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

@WebMvcTest(AssignatureEntryPoint.class)
public class AssignatureEntryPointTest {


    @MockBean
    private AssignatureUseCase assignatureUseCase;


    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("save Assignature ok")
    void saveAssignatureSuccess() throws Exception {
        //Arrange
        AssignatureDTO assignatureDTO =
                new AssignatureDTO(1L, "Matematicas", new ArrayList<>());

        ObjectMapper mapper = new ObjectMapper();

        Mockito
                .when(assignatureUseCase
                .saveAssignature(Mockito.any(AssignatureDTO.class)))
                .thenReturn(assignatureDTO);
        //Actions and Asserts
        mockMvc.perform(MockMvcRequestBuilders.post("/assignature")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(assignatureDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
//    @Test
//    @DisplayName("save Assignature Error")
//    void saveAssignatureError(){
//
//    }
}
