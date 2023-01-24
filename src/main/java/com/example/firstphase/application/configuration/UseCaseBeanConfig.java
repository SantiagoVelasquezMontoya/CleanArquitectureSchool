package com.example.firstphase.application.configuration;


import com.example.firstphase.domain.model.gateaways.AssignatureRepository;
import com.example.firstphase.domain.model.gateaways.StudentRepository;
import com.example.firstphase.domain.usecase.assignature.AssignatureUseCase;
import com.example.firstphase.domain.usecase.student.StudentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

    @Bean
    public StudentUseCase studentUseCase(StudentRepository studentRepository){
        return new StudentUseCase(studentRepository);
    }

    @Bean
    public AssignatureUseCase assignatureUseCase(AssignatureRepository assignatureRepository){
        return new AssignatureUseCase(assignatureRepository);
    }


}
