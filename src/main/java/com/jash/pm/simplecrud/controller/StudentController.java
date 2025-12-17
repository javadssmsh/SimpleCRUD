package com.jash.pm.simplecrud.controller;

import com.jash.pm.simplecrud.dto.StudentCreateDTO;
import com.jash.pm.simplecrud.dto.StudentResponseDTO;
import com.jash.pm.simplecrud.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public StudentResponseDTO create(@RequestBody StudentCreateDTO dto) {
        return studentService.create(dto);
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getById(@PathVariable Long id) {
        return studentService.getById(id);
    }

    @GetMapping
    public Set<StudentResponseDTO> getAll() {
        return studentService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}

