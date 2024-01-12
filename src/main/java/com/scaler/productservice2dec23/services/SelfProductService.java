package com.scaler.productservice2dec23.services;

import com.scaler.productservice2dec23.exceptions.ProductNotFoundException;
import com.scaler.productservice2dec23.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
@Service("selfproductservice")
//@Primary
public class SelfProductService implements ProductService{
    @Override
    public Product getSingleProduct(Long product_id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product updateProduct(Long product_id, Product product) {
        return null;
    }
}
