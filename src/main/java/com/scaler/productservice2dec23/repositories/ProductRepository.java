package com.scaler.productservice2dec23.repositories;

import com.scaler.productservice2dec23.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
