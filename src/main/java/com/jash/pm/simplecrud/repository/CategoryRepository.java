package com.jash.pm.simplecrud.repository;

import com.jash.pm.simplecrud.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
