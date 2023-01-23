package com.example.firstphase.application.configuration;


import com.example.firstphase.domain.model.gateaways.StudentRepository;
import com.example.firstphase.domain.usecase.student.StudentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

    @Bean
    public StudentUseCase studentUseCase(StudentRepository studentRepository){
        return new StudentUseCase(studentRepository);
    }
}
