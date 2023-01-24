package com.example.firstphase.domain.usecase.assignature;

import com.example.firstphase.domain.model.assignature.Assignature;
import com.example.firstphase.domain.model.assignature.dto.AssignatureDTO;
import com.example.firstphase.domain.model.gateaways.AssignatureRepository;
import com.example.firstphase.infrastructure.adapters.jpa.adapters.assignature.AssignatureAdapterRepository;
import com.example.firstphase.infrastructure.adapters.jpa.entity.assignature.AssignatureDBO;

public class AssignatureUseCase {

    public final AssignatureRepository assignatureRepository;


    public AssignatureUseCase(AssignatureRepository assignatureRepository) {
        this.assignatureRepository = assignatureRepository;
    }

    public AssignatureDBO saveAssignature(AssignatureDTO assignatureDTO){
        AssignatureDBO assignatureDBO = new AssignatureDBO(assignatureRepository.saveAssignature(assignatureDTO));
        return assignatureDBO;

    }
}
