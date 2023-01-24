package com.example.firstphase.infrastructure.adapters.jpa.entrypoint;


import com.example.firstphase.domain.model.assignature.dto.AssignatureDTO;
import com.example.firstphase.domain.usecase.assignature.AssignatureUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/assignature")
public class AssignatureEntryPoint {

    public final AssignatureUseCase assignatureUseCase;

    public AssignatureEntryPoint(AssignatureUseCase assignatureUseCase) {
        this.assignatureUseCase = assignatureUseCase;
    }

    @PostMapping
    public ResponseEntity<?> saveAssignature(@RequestBody AssignatureDTO assignatureDTO){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(new AssignatureDTO(assignatureUseCase.saveAssignature(assignatureDTO)));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAssignatures(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(assignatureUseCase.getAssignatures());
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
