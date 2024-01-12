package com.scaler.productservice2dec23.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
   private String title;
   private Double price;
   private String imageUrl;
   private String description;
   @ManyToOne
   private Category category;
}
