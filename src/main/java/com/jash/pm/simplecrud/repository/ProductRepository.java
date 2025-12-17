package com.jash.pm.simplecrud.repository;

import com.jash.pm.simplecrud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
