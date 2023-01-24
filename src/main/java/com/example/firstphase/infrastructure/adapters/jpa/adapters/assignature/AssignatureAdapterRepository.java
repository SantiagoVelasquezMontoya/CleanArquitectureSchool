package com.example.firstphase.infrastructure.adapters.jpa.adapters.assignature;

import com.example.firstphase.infrastructure.adapters.jpa.entity.assignature.AssignatureDBO;
import org.springframework.data.repository.CrudRepository;

public interface AssignatureAdapterRepository extends CrudRepository <AssignatureDBO, Integer> {
}
