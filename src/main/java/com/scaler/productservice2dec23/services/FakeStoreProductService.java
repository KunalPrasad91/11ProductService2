package com.scaler.productservice2dec23.services;

import com.scaler.productservice2dec23.dtos.FakeStoreProductDto;
import com.scaler.productservice2dec23.models.Category;
import com.scaler.productservice2dec23.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    RestTemplate restTemplate;

    @Autowired
    FakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public Product convertFakeStoreProductDtotoProduct(FakeStoreProductDto fakeStoreProductDto)
    {
        Product product = new Product();

        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDto.getCategory());

        return product;
    }

    @Override
    public Product getSingleProduct(Long product_id) {

        FakeStoreProductDto productDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + product_id,
                FakeStoreProductDto.class
        );

        return convertFakeStoreProductDtotoProduct(productDto);
    }

    @Override
    public List<Product> getAllProduct() {

        List<Product> answer = new ArrayList<>();

        // List<T>, T is earsed at runtime, by Java Generics Type Erasure
        // so at runtime how to convert url https://fakestoreapi.com/products
        // to List<?> of what type is not known so gives a error

        /*
        List<FakeStoreProductDto> fakeStoreProductDtos = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                List<FakeStoreProductDto.class>.class
        );
        */

        // Solution is create array of Fakeproduct instead.

        FakeStoreProductDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreProductDto[].class
        );

        for(FakeStoreProductDto dto : response)
        {
           answer.add(convertFakeStoreProductDtotoProduct(dto));
        }

        return answer;
    }
}
