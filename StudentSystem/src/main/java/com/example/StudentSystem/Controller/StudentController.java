package com.example.StudentSystem.controller;

import com.example.StudentSystem.entity.Student;
import com.example.StudentSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRepository repo;

    // GET all students
    @GetMapping
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // GET student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return repo.findById(id)
                .map(student -> ResponseEntity.ok().body(student))
                .orElse(ResponseEntity.notFound().build());
    }

    // POST create student
    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student savedStudent = repo.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    // PUT update student
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        return repo.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setPercentage(updatedStudent.getPercentage());
                    student.setBranch(updatedStudent.getBranch());
                    Student saved = repo.save(student);
                    return ResponseEntity.ok().body(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}