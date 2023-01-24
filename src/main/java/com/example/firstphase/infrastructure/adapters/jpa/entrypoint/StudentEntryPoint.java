package com.example.firstphase.infrastructure.adapters.jpa.entrypoint;


import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.domain.usecase.student.StudentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentEntryPoint {

    public final StudentUseCase studentUseCase;

    @PostMapping
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO){
        return new StudentDTO(studentUseCase.saveStudent(studentDTO));
    }

    @PostMapping("/enroll")
    public ResponseEntity<?> enrollStudent (@RequestBody StudentDTO studentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentUseCase.enrollStudent(studentDTO));
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getStudents(){
        return  ResponseEntity.status(HttpStatus.OK).body(studentUseCase.getStudents());
    }


}
