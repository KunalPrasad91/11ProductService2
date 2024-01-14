package com.scaler.productservice2dec23.repositories;

import com.scaler.productservice2dec23.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatergoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findById(Long category_id);
    Optional<Category> findByName(String name);
}
