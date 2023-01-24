package com.example.firstphase.infrastructure.adapters.jpa.entrypoint;


import com.example.firstphase.domain.model.assignature.dto.AssignatureDTO;
import com.example.firstphase.domain.usecase.assignature.AssignatureUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/assignature")
public class AssignatureEntryPoint {

    public final AssignatureUseCase assignatureUseCase;

    public AssignatureEntryPoint(AssignatureUseCase assignatureUseCase) {
        this.assignatureUseCase = assignatureUseCase;
    }

    @PostMapping
    public AssignatureDTO saveAssignature(@RequestBody AssignatureDTO assignatureDTO){
        return new AssignatureDTO(assignatureUseCase.saveAssignature(assignatureDTO));
    }
}
