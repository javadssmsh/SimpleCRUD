package com.jash.pm.simplecrud.repository;

import com.jash.pm.simplecrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
