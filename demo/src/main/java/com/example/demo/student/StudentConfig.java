package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student manuel = new Student("Manuel", "manuel@gmail.com", LocalDate.of(1999, 1, 5));

            Student martina = new Student("Martina", "martina@gmail.com", LocalDate.of(2000, 3, 8));

            repository.saveAll(List.of(manuel, martina));
        };
    }
}
