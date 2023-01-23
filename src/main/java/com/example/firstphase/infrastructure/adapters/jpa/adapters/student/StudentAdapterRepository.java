package com.example.firstphase.infrastructure.adapters.jpa.adapters.student;

import com.example.firstphase.infrastructure.adapters.jpa.entity.student.StudentDBO;
import org.springframework.data.repository.CrudRepository;

public interface StudentAdapterRepository extends CrudRepository<StudentDBO, Integer> {
}
