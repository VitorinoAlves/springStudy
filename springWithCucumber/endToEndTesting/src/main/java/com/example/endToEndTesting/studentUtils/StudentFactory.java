package com.example.endToEndTesting.studentUtils;

import com.example.endToEndTesting.studentUtils.domain.Student;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class StudentFactory {

    private static final Faker FAKER = new Faker(new Locale("pt-BR"));

    public static Student createNewStudentDefault() {
        // Generate a random, plausible date of birth
        Date pastDate = FAKER.date().past(15 * 365, TimeUnit.DAYS); // Approx. 15 years ago
        LocalDate randomDob = pastDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();


        return Student.builder()
                .name(FAKER.name().fullName())
                .email(FAKER.internet().emailAddress())
                .dob(randomDob)
                .build();
    }
}
