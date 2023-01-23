package com.example.firstphase.infrastructure.adapters.jpa;

import com.example.firstphase.infrastructure.adapters.jpa.entity.student.StudentDBO;
import org.springframework.data.repository.CrudRepository;

public interface ProductAdapterRepository extends CrudRepository<StudentDBO, Integer> {
}
