package com.jash.pm.simplecrud.service;

import com.jash.pm.simplecrud.dto.ProductCreateDTO;
import com.jash.pm.simplecrud.dto.ProductResponseDTO;
import com.jash.pm.simplecrud.entity.Category;
import com.jash.pm.simplecrud.entity.Product;
import com.jash.pm.simplecrud.repository.CategoryRepository;
import com.jash.pm.simplecrud.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;

    public ProductResponseDTO create(ProductCreateDTO dto) {
        Category category = categoryRepo.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = new Product();
        product.setName(dto.getName());
        product.setCategory(category);

        product = productRepo.save(product);

        return toResponse(product);
    }

    public List<ProductResponseDTO> getAll() {
        return productRepo.findAll()
                .stream().map(this::toResponse).toList();
    }

    public ProductResponseDTO getById(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return toResponse(product);
    }

    public ProductResponseDTO update(Long id, ProductCreateDTO dto) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Category category = categoryRepo.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        product.setName(dto.getName());
        product.setCategory(category);

        product = productRepo.save(product);
        return toResponse(product);
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    private ProductResponseDTO toResponse(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getCategory().getTitle());
    }
}
