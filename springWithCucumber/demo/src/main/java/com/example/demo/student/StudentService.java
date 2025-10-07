package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        checkIfStudentExists(studentId);
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student studentToUpdate = checkIfStudentExists(studentId);

        if(name != null && !name.isEmpty() && !Objects.equals(studentToUpdate.getName(), name)){
            studentToUpdate.setName(name);
        }

        if(email != null && !email.isEmpty() && !Objects.equals(studentToUpdate.getEmail(), email)){
            checkUniqueEmail(email);
            studentToUpdate.setEmail(email);
        }

    }

    public Student checkIfStudentExists(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id " + studentId + " does not exist"
                ));
    }

    public void checkUniqueEmail(String email) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
    }
}
