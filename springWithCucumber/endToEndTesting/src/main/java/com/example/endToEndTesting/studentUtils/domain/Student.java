package com.example.endToEndTesting.studentUtils.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Student {
    @Id
    private Long id;
    private String name;
    private LocalDate dob;
    private String  email;
    @Transient
    private Integer age;
}
