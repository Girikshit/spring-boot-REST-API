package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.FEBRUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student erik= new Student("Erik","erik@gmail.com", LocalDate.of(2000, FEBRUARY,3));
            Student jay= new Student("JAy","erik@gmail.com", LocalDate.of(2010, FEBRUARY,9));
            repository.saveAll(List.of(erik,jay));
        };

    }
}
