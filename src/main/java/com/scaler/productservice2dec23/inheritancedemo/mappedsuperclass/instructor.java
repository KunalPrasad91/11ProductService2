package com.scaler.productservice2dec23.inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "msp_instructor")
public class instructor extends  user{

    private  String favouriteStudent;

}
