package com.example.firstphase.domain.usecase.assignature;

import com.example.firstphase.domain.model.assignature.Assignature;
import com.example.firstphase.domain.model.assignature.dto.AssignatureDTO;
import com.example.firstphase.domain.model.gateaways.AssignatureRepository;
import com.example.firstphase.infrastructure.adapters.jpa.adapters.assignature.AssignatureAdapterRepository;
import com.example.firstphase.infrastructure.adapters.jpa.entity.assignature.AssignatureDBO;

import java.util.List;
import java.util.stream.Collectors;

public class AssignatureUseCase {

    public final AssignatureRepository assignatureRepository;


    public AssignatureUseCase(AssignatureRepository assignatureRepository) {
        this.assignatureRepository = assignatureRepository;
    }

    public AssignatureDTO saveAssignature(AssignatureDTO assignatureDTO){
        AssignatureDBO assignatureDBO = new AssignatureDBO(assignatureRepository.saveAssignature(AssignatureDTO.toAssignature(assignatureDTO)));
        return new AssignatureDTO(assignatureDBO);
    }
    public List<AssignatureDTO> getAssignatures(){
        return assignatureRepository.getAssignatures().stream().map(AssignatureDTO::new).collect(Collectors.toList());
    }

    public AssignatureDTO getAssignature(Integer assignatureId){
        return new AssignatureDTO(assignatureRepository.getAssignature(assignatureId));
    }
}
