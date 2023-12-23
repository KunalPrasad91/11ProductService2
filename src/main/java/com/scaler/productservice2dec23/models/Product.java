package com.scaler.productservice2dec23.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
   private Long id;
   private String title;
   private Double price;
   private String imageUrl;
   private String description;
   private Category category;
}
