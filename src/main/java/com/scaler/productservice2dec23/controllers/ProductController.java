package com.scaler.productservice2dec23.controllers;


import com.scaler.productservice2dec23.models.Product;
import com.scaler.productservice2dec23.services.FakeStoreProductService;
import com.scaler.productservice2dec23.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    @Autowired
    ProductController(FakeStoreProductService fakeStoreProductService)
    {
        this.productService = fakeStoreProductService;
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long product_id)
    {
        return productService.getSingleProduct(product_id);
    }

    @GetMapping()
    public List<Product> getAllProduct()
    {
        return  productService.getAllProduct();
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,
                                 @RequestBody Product product)
    {
        return productService.updateProduct(id,product);
    }

    @PatchMapping("/{id}")
    public Product patchProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return new Product();
    }

    @PostMapping()
    public Product addNewProduct(@RequestBody  Product product)
    {
        Product p = new Product();
        return  p;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id)
    {
        return;
    }
}
