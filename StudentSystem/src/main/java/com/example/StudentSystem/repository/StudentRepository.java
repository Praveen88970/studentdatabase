package com.example.StudentSystem.repository;

import com.example.StudentSystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}