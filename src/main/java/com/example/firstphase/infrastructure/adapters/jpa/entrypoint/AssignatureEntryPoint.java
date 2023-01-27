package com.example.firstphase.infrastructure.adapters.jpa.entrypoint;


import com.example.firstphase.domain.model.assignature.dto.AssignatureDTO;
import com.example.firstphase.domain.usecase.assignature.AssignatureUseCase;
import com.example.firstphase.infrastructure.adapters.jpa.utilities.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.text.FieldPosition;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/assignature")
public class AssignatureEntryPoint {


    public final AssignatureUseCase assignatureUseCase;

    public AssignatureEntryPoint(AssignatureUseCase assignatureUseCase) {
        this.assignatureUseCase = assignatureUseCase;
    }

    @PostMapping
    public ResponseEntity<?> saveAssignature(@RequestBody AssignatureDTO assignatureDTO){

            return ResponseEntity.status(HttpStatus.CREATED).body(assignatureUseCase.saveAssignature(assignatureDTO));

    }

    @GetMapping
    public ResponseEntity<?> getAssignatures(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(assignatureUseCase.getAssignatures());
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getAssignature(@PathVariable(name = "id") Integer assignatureId){
            return ResponseEntity.status(HttpStatus.OK).body(assignatureUseCase.getAssignature(assignatureId));

    }




}
