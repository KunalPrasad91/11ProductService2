package com.scaler.productservice2dec23.inheritancedemo.tableperclass;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name =  "tpc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class user {

    @Id
    private Long id;
    private String name;
    private String email;

}
