package com.example.firstphase.infrastructure.adapters.jpa.adapters.student;

import com.example.firstphase.infrastructure.adapters.jpa.entity.student.StudentDBO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentAdapterRepository extends CrudRepository<StudentDBO, Integer> {
    //@Query("select s from StudentDBO s where s.assignatureDBO.id = ?1")
    List<StudentDBO> findByAssignatureDBO_Id(Integer id);




}
