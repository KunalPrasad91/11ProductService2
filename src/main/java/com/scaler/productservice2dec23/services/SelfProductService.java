package com.scaler.productservice2dec23.services;

import com.scaler.productservice2dec23.exceptions.ProductNotFoundException;
import com.scaler.productservice2dec23.models.Category;
import com.scaler.productservice2dec23.models.Product;
import com.scaler.productservice2dec23.repositories.CatergoryRepository;
import com.scaler.productservice2dec23.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
@Service("selfproductservice")
//@Primary
public class SelfProductService implements ProductService{
    ProductRepository productRepository;
    CatergoryRepository catergoryRepository;
    @Autowired
    SelfProductService(ProductRepository productRepository,
                       CatergoryRepository catergoryRepository)
    {
        this.productRepository = productRepository;
        this.catergoryRepository = catergoryRepository;
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
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long product_id, Product product) throws ProductNotFoundException {

        Optional<Product> productOptional = productRepository.findById(product_id);

        if(productOptional.isEmpty())
        {
            throw new ProductNotFoundException("Product with " + product_id + " not found" );
        }

        Product savedProduct = productOptional.get();

        if(product.getTitle() != null)
        {
            savedProduct.setTitle(product.getTitle());
        }

        if(product.getDescription()!= null)
        {
            savedProduct.setDescription(product.getDescription());
        }

        if(product.getPrice()!= null)
        {
            savedProduct.setPrice(product.getPrice());
        }

        if(product.getImageUrl() != null)
        {
            savedProduct.setImageUrl(product.getImageUrl());
        }

        return productRepository.save(savedProduct);

    }

    @Override
    public Product addNewProduct(Product product) {

        String categoryName = product.getCategory().getName();
        Optional<Category> categoryOptional = catergoryRepository.findByName(categoryName);
        Category savedCategory;

        if(categoryOptional.isEmpty())
        {
    /*        savedCategory = new Category();
            savedCategory.setName(categoryName);
            savedCategory = catergoryRepository.save(savedCategory);
            product.setCategory(savedCategory);*/
            product.setCategory(catergoryRepository.save(product.getCategory()));
        }
        else
        {
            product.setCategory(categoryOptional.get());
        }

        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    @Override
    public void deleteProduct(Long product_id) {

        productRepository.deleteById(product_id);

        return;
    }
}
