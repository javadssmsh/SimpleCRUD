package com.jash.pm.simplecrud.service;

import com.jash.pm.simplecrud.dto.StudentCreateDTO;
import com.jash.pm.simplecrud.dto.StudentResponseDTO;
import com.jash.pm.simplecrud.entity.Course;
import com.jash.pm.simplecrud.entity.Student;
import com.jash.pm.simplecrud.repository.CourseRepository;
import com.jash.pm.simplecrud.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public StudentResponseDTO create(StudentCreateDTO dto) {
        Student student = new Student();
        student.setFullName(dto.getFullName());

        // Load courses based on IDs
        Set<Course> courses = courseRepo.findAllById(dto.getCourseIds())
                .stream()
                .collect(Collectors.toSet());

        student.setCourses(courses);

        Student saved = studentRepo.save(student);

        return mapToDto(saved);
    }

    public StudentResponseDTO getById(Long id) {
        Student student = studentRepo.findById(id).orElseThrow();
        return mapToDto(student);
    }

    public Set<StudentResponseDTO> getAll() {
        return studentRepo.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toSet());
    }

    public void delete(Long id) {
        studentRepo.deleteById(id);
    }

    private StudentResponseDTO mapToDto(Student student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setFullName(student.getFullName());
        dto.setCourses(
                student.getCourses()
                        .stream()
                        .map(Course::getTitle)
                        .collect(Collectors.toSet())
        );
        return dto;
    }
}