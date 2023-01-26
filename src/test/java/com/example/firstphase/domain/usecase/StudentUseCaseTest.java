package com.example.firstphase.domain.usecase;


import com.example.firstphase.domain.model.assignature.dto.AssignatureDTO;
import com.example.firstphase.domain.model.student.Student;
import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.domain.usecase.student.StudentUseCase;
import com.example.firstphase.infrastructure.adapters.jpa.adapters.student.StudentAdapterRepository;
import com.example.firstphase.infrastructure.adapters.jpa.adapters.student.StudentRepositoryAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentUseCaseTest {


    @Mock
    private StudentRepositoryAdapter IStudentRepo;

    @InjectMocks
    private StudentUseCase  studentUseCase;


    @Test
    void enrollStudent(){
        String expectedOutput =
                "The student was saved.";
        StudentDTO studentDTO = new StudentDTO
                (1L, "Santiago", 123,  "santiago@gmail.com"
                        , new AssignatureDTO(1L, "Python", null));

        Student student = StudentDTO.toStudent(studentDTO);

        when(IStudentRepo.enrollStudent(any(Student.class)))
                .thenReturn(expectedOutput);

        String res = studentUseCase.enrollStudent(studentDTO);

        Assertions.assertEquals(expectedOutput,res);
    }

    @Test
    void getStudentById(){
        Integer inputId = 1;
        StudentDTO studentDTO = new StudentDTO
                (1L, "Santiago", 123,  "santiago@gmail.com"
                        , new AssignatureDTO(1L, "Python", null));

        Student student = StudentDTO.toStudent(studentDTO);

        when(IStudentRepo.getStudent(any(Integer.class)))
                .thenReturn(student);

        StudentDTO res = studentUseCase.getStudent(inputId);

        Assertions.assertEquals(studentDTO.getEmail(), res.getEmail());
    }
}
