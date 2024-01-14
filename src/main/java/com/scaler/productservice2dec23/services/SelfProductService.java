package com.scaler.productservice2dec23.services;

import com.scaler.productservice2dec23.exceptions.ProductNotFoundException;
import com.scaler.productservice2dec23.models.Product;
import com.scaler.productservice2dec23.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
@Service("selfproductservice")
//@Primary
public class SelfProductService implements ProductService{
    ProductRepository productRepository;
    @Autowired
    SelfProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }
    @Override
    public Product getSingleProduct(Long product_id) throws ProductNotFoundException {
        // Experimenting JPA Buddy
       // Optional<Product> productOptional = productRepository.findByIdOrTitle(product_id,"Kunal");

        Optional<Product> productOptional = productRepository.findById(product_id);

        if(productOptional.isEmpty())
        {
            throw new ProductNotFoundException("Product with " + product_id +" not found");
        }
        else
            return productOptional.get();
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
