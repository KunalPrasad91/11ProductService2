package com.scaler.productservice2dec23.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msp_mentor")
public class mentor extends user{

    private double averageRating;
}
