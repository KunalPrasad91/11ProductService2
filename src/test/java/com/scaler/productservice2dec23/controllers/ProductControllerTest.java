package com.scaler.productservice2dec23.controllers;

import com.scaler.productservice2dec23.models.Product;
import com.scaler.productservice2dec23.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Test
    void testProductControllerGetAllPro()
    {
        List<Product> products = new ArrayList<>();
        Product p1 = new Product();
        p1.setTitle("Iphone 15");
        products.add(p1);
        Product p2 = new Product();
        p2.setTitle("Iphone 15 max");
        products.add(p2);
        Product p3 = new Product();
        p3.setTitle("Iphone 15 max pro");
        products.add(p3);

        List<Product> prodToPass = new ArrayList<>();

        for(Product p : products)
        {
            Product np = new Product();
            np.setTitle(p.getTitle());
            prodToPass.add(np);
        }

        // Arrange
        when(
                productService.getAllProduct()
        ).thenReturn(
                prodToPass
        );

        //Act
        List<Product> response = productController.getAllProduct();

        // Assert
        assertEquals(products.size(),response.size());

        for (int i = 0; i < products.size(); i++) {
                assertEquals(products.get(i).getTitle(),response.get(i).getTitle());
        }

    }


}