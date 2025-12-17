package com.jash.pm.simplecrud.repository;

import com.jash.pm.simplecrud.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
