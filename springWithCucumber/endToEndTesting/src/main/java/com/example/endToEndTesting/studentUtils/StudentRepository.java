package com.example.endToEndTesting.studentUtils;

import com.example.endToEndTesting.studentUtils.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
