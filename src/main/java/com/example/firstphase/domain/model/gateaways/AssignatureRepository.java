package com.example.firstphase.domain.model.gateaways;

import com.example.firstphase.domain.model.assignature.Assignature;
import com.example.firstphase.domain.model.assignature.dto.AssignatureDTO;

import java.util.List;

public interface AssignatureRepository {

    public Assignature saveAssignature(Assignature assignature);

    public List<Assignature> getAssignatures();

}
