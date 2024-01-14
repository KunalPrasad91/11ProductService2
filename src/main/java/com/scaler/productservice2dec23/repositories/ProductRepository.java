package com.scaler.productservice2dec23.repositories;

import com.scaler.productservice2dec23.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Override
    Optional<Product> findById(Long aLong);

    List<Product> findByTitleContaining(String word);

    Optional<Product> findByIdOrTitle(Long id, String title);
}
