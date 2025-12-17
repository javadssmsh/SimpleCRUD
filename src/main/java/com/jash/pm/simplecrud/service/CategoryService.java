package com.jash.pm.simplecrud.service;

import com.jash.pm.simplecrud.dto.CategoryCreateDTO;
import com.jash.pm.simplecrud.dto.CategoryResponseDTO;
import com.jash.pm.simplecrud.entity.Category;
import com.jash.pm.simplecrud.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepo;

    public CategoryResponseDTO create(CategoryCreateDTO dto) {
        Category category = new Category();
        category.setTitle(dto.getTitle());

        Category saved = categoryRepo.save(category);
        return mapToResponse(saved);
    }

    public List<CategoryResponseDTO> getAll() {
        return categoryRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public CategoryResponseDTO getOne(Long id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return mapToResponse(category);
    }

    public CategoryResponseDTO update(Long id, CategoryCreateDTO dto) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setTitle(dto.getTitle());

        Category updated = categoryRepo.save(category);
        return mapToResponse(updated);
    }

    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }

    // ---------------------------------------------------
    // Mapping
    // ---------------------------------------------------

    private CategoryResponseDTO mapToResponse(Category category) {
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setId(category.getId());
        dto.setTitle(category.getTitle());

        return dto;
    }
}

