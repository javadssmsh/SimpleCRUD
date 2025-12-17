package com.jash.pm.simplecrud.controller;

import com.jash.pm.simplecrud.dto.UserCreateDTO;
import com.jash.pm.simplecrud.dto.UserResponseDTO;
import com.jash.pm.simplecrud.entity.User;
import com.jash.pm.simplecrud.repository.UserRepository;
import com.jash.pm.simplecrud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepo;
    private final UserService userService;


    @PostMapping
    public UserResponseDTO create(@RequestBody UserCreateDTO user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserResponseDTO> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserResponseDTO getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserResponseDTO update(@PathVariable Long id, @RequestBody UserCreateDTO dto) {
        return userService.updateUser(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

