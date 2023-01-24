package com.example.firstphase.infrastructure.adapters.jpa.adapters.assignature;

import com.example.firstphase.domain.model.assignature.Assignature;
import com.example.firstphase.domain.model.assignature.dto.AssignatureDTO;
import com.example.firstphase.domain.model.gateaways.AssignatureRepository;
import com.example.firstphase.infrastructure.adapters.jpa.entity.assignature.AssignatureDBO;
import org.springframework.stereotype.Repository;

@Repository
public class AssignatureRepositoryAdapter implements AssignatureRepository {

    public final AssignatureAdapterRepository assignatureAdapterRepository;

    public AssignatureRepositoryAdapter(AssignatureAdapterRepository assignatureAdapterRepository) {
        this.assignatureAdapterRepository = assignatureAdapterRepository;
    }

    @Override
    public Assignature saveAssignature(AssignatureDTO assignatureDTO) {
        AssignatureDBO assignatureDBO = assignatureAdapterRepository.save(new AssignatureDBO(assignatureDTO));
        return AssignatureDBO.toAssignature(assignatureDBO);
    }
}
