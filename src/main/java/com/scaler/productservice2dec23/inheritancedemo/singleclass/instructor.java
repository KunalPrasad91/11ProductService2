package com.scaler.productservice2dec23.inheritancedemo.singleclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name =  " sc_instructor")
@DiscriminatorValue(value = "2")
public class instructor extends  user{

    private  String favouriteStudent;

}
