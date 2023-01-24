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
    public ResponseEntity<?> saveStudent(@RequestBody StudentDTO studentDTO){
        try{
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentUseCase.saveStudent(studentDTO));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/enroll")
    public ResponseEntity<?> enrollStudent (@RequestBody StudentDTO studentDTO){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(studentUseCase.enrollStudent(studentDTO));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getStudents(){
        try {
            return  ResponseEntity.status(HttpStatus.OK).body(studentUseCase.getStudents());
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/enrolled/{id}")
    public ResponseEntity<?> getEnrolledStudents(@PathVariable(name = "id") Integer assignatureId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(studentUseCase.getEnrolledStudents(assignatureId));
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
