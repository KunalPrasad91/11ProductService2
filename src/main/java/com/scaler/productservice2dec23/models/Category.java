package com.scaler.productservice2dec23.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    private String name;
    //@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "category", fetch = FetchType.EAGER)
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "category", fetch = FetchType.LAZY)
    List<Product> products;
}
