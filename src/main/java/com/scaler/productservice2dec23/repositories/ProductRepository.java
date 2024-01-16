package com.scaler.productservice2dec23.repositories;

import com.scaler.productservice2dec23.models.Product;
import com.scaler.productservice2dec23.repositories.projections.ProductWithIdAndTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Override
    Optional<Product> findById(Long aLong);

    @Override
    Product save(Product product);

    List<Product> findByTitleContaining(String word);

    List<Product> findAll();

    @Override
    void deleteById(Long product_id);

    Optional<Product> findByIdOrTitle(Long id, String title);

    // Declared
    // HQL
    // Native

    @Query("select p from Product p")
    List<Product> HQLQueryGetProduct();

    @Query("select p from Product p where p.id = :id")
    Optional<Product> HQLQueryGetProductById(@Param("id") Long id);


    @Query("select p.id as id, p.title as title from Product p where p.id = :id")
    List<ProductWithIdAndTitle> HQLgetProductIdandTitle(@Param("id") Long id);

    @Query(value = "select p.id as id, p.title as title from Product p where p.id = :id",nativeQuery = true)
    List<ProductWithIdAndTitle> SQLNativeQuerygetProductIdandTitle(@Param("id") Long id);

}
