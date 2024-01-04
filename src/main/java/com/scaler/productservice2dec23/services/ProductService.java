package com.scaler.productservice2dec23.services;

import com.scaler.productservice2dec23.models.Product;

import java.util.List;

public interface ProductService {
    public Product getSingleProduct(Long product_id);
    public List<Product> getAllProduct();
}
