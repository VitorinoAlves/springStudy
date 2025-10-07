package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student carlos = new Student(
                    "Carlos",
                    LocalDate.of(2000, Month.JANUARY, 15),
                    "test@email.com"
            );

            Student mariam = new Student(
                    "Mariam",
                    LocalDate.of(1998, Month.JANUARY, 25),
                    "mariam@email.com"
            );

            repository.saveAll(
                    List.of(carlos,mariam)
            );
        };
    }
}
