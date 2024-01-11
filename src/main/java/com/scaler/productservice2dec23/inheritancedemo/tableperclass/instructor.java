package com.scaler.productservice2dec23.inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tpc_instructor")
public class instructor extends user{

    private  String favouriteStudent;

}
