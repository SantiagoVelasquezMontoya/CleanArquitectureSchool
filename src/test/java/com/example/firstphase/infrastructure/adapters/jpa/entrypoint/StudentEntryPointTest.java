package com.example.firstphase.infrastructure.adapters.jpa.entrypoint;


import com.example.firstphase.domain.model.assignature.dto.AssignatureDTO;
import com.example.firstphase.domain.model.student.Student;
import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.domain.usecase.student.StudentUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.print.attribute.standard.Media;

import java.awt.*;

import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(StudentEntryPoint.class)
public class StudentEntryPointTest {


    @MockBean
    private StudentUseCase studentUseCase;

    @Autowired
    private MockMvc mockMvc;



    @Test
    void saveStudentSuccess() throws Exception {
        //Arrange
        StudentDTO studentDTO = new StudentDTO(
                1L, "Santiago", 123, "santiago@email.com",
                new AssignatureDTO(1L ,"Python"));

        String expectedOutput = "The student was saved.";

        ObjectMapper mapper = new ObjectMapper();

        Mockito
                .when(studentUseCase
                .enrollStudent(any(StudentDTO.class)))
                .thenReturn(expectedOutput);

        //Actions and Asserts
        mockMvc.perform(MockMvcRequestBuilders.post("/student")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(studentDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void getStudentByIdSuccess() throws Exception {
        Integer inputId = 1;

        StudentDTO studentDTO = new StudentDTO(
                1L, "Santiago", 123, "santiago@email.com",
                new AssignatureDTO(1L ,"Python"));

        Mockito
                .when(studentUseCase
                        .getStudent(any(Integer.class)))
                        .thenReturn(studentDTO);

        //Actions and Assert;
        mockMvc.perform(MockMvcRequestBuilders.get("/student/" + inputId))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getStudentByIdError() throws Exception {
        StudentDTO studentDTO = new StudentDTO(
                1L, "Santiago", 123, "santiago@email.com",
                new AssignatureDTO(1L ,"Python"));

        Mockito
                .when(studentUseCase
                        .getStudent(any(Integer.class)))
                .thenReturn(studentDTO);

        //Actions and Assert;
        mockMvc.perform(MockMvcRequestBuilders.get("/student/"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
