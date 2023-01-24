package com.example.firstphase.domain.model.gateaways;

import com.example.firstphase.domain.model.assignature.Assignature;
import com.example.firstphase.domain.model.assignature.dto.AssignatureDTO;

public interface AssignatureRepository {

    public Assignature saveAssignature(AssignatureDTO assignatureDTO);

}
