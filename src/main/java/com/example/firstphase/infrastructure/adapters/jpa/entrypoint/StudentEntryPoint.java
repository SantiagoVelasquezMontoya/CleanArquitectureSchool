package com.example.firstphase.infrastructure.adapters.jpa.entrypoint;


import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.domain.usecase.student.StudentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentEntryPoint {

    public final StudentUseCase studentUseCase;

    @PostMapping
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO){
        return new StudentDTO(studentUseCase.saveStudent(studentDTO));
    }
}
