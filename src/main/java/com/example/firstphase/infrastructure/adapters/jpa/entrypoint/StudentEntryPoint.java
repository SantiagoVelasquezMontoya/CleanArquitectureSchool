package com.example.firstphase.infrastructure.adapters.jpa.entrypoint;


import com.example.firstphase.domain.model.student.dto.StudentDTO;
import com.example.firstphase.domain.usecase.student.StudentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
@CrossOrigin(allowedHeaders = "*" ,origins =  "*")
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
        }
        catch (Exception e){
         return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<?> getStudents(){
        List<StudentDTO> studentDTOList = studentUseCase.getStudents();
        try {
            if(studentDTOList.isEmpty()) return ResponseEntity.
                    status(HttpStatus.NOT_FOUND).body(studentDTOList);
            return  ResponseEntity.status(HttpStatus.OK).body(studentDTOList);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/enrolled/{id}")
    public ResponseEntity<?> getEnrolledStudents(@PathVariable(name = "id") Integer assignatureId){
        List<StudentDTO> studentDTOList = studentUseCase.getEnrolledStudents(assignatureId);
        if(studentDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentDTOList);
        } else{
            return ResponseEntity.status(HttpStatus.OK).body(studentUseCase.getEnrolledStudents(assignatureId));
        }
    }

    @GetMapping("/enrolled/all")
    public ResponseEntity<?> getAllEnrolledStudents(){
        List<StudentDTO> studentDTOList = studentUseCase.getAllEnrolledStudents();
        if(studentDTOList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentDTOList);
        } else{
            return ResponseEntity.status(HttpStatus.OK).body(studentUseCase.getAllEnrolledStudents());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteStudent(@RequestBody StudentDTO studentDTO){
     try{
         return ResponseEntity.status(HttpStatus.OK).body(studentUseCase.deleteStudent(studentDTO));
     } catch (Exception e){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
     }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable(name= "id") Integer studentId){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentUseCase.getStudent(studentId));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
