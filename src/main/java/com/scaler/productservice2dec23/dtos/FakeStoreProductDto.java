package com.scaler.productservice2dec23.dtos;

import lombok.Getter;
import lombok.Setter;
import org.apache.el.stream.Stream;

@Getter
@Setter

public class FakeStoreProductDto {
    private  Long id;
    private String title;
    private Double price;
    private String category;
    private  String description;
    private  String image;
}
