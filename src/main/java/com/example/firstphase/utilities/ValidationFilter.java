package com.example.firstphase.utilities;

import org.springframework.context.annotation.Configuration;


@Configuration
public class ValidationFilter {

    public boolean haveOnlyLetters(String string){
        return (string.matches("^[aA-zZ]+"));
    }
}
