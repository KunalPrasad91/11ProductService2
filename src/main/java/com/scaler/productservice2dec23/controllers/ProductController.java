package com.scaler.productservice2dec23.controllers;


import com.scaler.productservice2dec23.models.Product;
import com.scaler.productservice2dec23.services.FakeStoreProductService;
import com.scaler.productservice2dec23.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
