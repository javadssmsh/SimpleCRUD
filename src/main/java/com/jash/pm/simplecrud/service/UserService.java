package com.jash.pm.simplecrud.service;

import com.jash.pm.simplecrud.dto.UserCreateDTO;
import com.jash.pm.simplecrud.dto.UserResponseDTO;
import com.jash.pm.simplecrud.entity.User;
import com.jash.pm.simplecrud.entity.UserProfile;
import com.jash.pm.simplecrud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepo;

    public UserResponseDTO createUser(UserCreateDTO dto) {
        User user = mapDtoToEntity(dto);
        User saved = userRepo.save(user);
        return mapEntityToResponse(saved);
    }

    public List<UserResponseDTO> getAllUsers() {
        return userRepo.findAllWithProfile()
                .stream()
                .map(this::mapEntityToResponse)
                .toList();
    }

    public UserResponseDTO getUserById(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapEntityToResponse(user);
    }

    public UserResponseDTO updateUser(Long id, UserCreateDTO dto) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(dto.getName());
        user.getProfile().setAddress(dto.getProfile().getAddress());

        User updated = userRepo.save(user);
        return mapEntityToResponse(updated);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    // ---------------------------------
    // Mapping helpers
    // ---------------------------------

    private User mapDtoToEntity(UserCreateDTO dto) {
        User user = new User();
        user.setName(dto.getName());

        UserProfile profile = new UserProfile();
        profile.setAddress(dto.getProfile().getAddress());

        user.setProfile(profile);
        return user;
    }

    private UserResponseDTO mapEntityToResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getProfile().getAddress()
        );
    }
}
