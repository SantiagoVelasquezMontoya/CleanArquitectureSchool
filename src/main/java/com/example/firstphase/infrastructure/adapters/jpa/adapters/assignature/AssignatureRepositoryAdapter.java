package com.example.firstphase.infrastructure.adapters.jpa.adapters.assignature;

import com.example.firstphase.domain.model.assignature.Assignature;
import com.example.firstphase.domain.model.assignature.dto.AssignatureDTO;
import com.example.firstphase.domain.model.gateaways.AssignatureRepository;
import com.example.firstphase.infrastructure.adapters.jpa.entity.assignature.AssignatureDBO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AssignatureRepositoryAdapter implements AssignatureRepository {

    public final AssignatureAdapterRepository assignatureAdapterRepository;

    public AssignatureRepositoryAdapter(AssignatureAdapterRepository assignatureAdapterRepository) {
        this.assignatureAdapterRepository = assignatureAdapterRepository;
    }

    @Override
    public Assignature saveAssignature(Assignature assignature) {
        AssignatureDBO assignatureDBO = assignatureAdapterRepository.save(new AssignatureDBO(assignature));
        return AssignatureDBO.toAssignature(assignatureDBO);
    }

    @Override
    public List<Assignature> getAssignatures() {
            List<AssignatureDBO> assignatureDBOList = (List<AssignatureDBO>) assignatureAdapterRepository.findAll();
        return assignatureDBOList.stream().map(AssignatureDBO::toAssignature).collect(Collectors.toList());
    }
}
