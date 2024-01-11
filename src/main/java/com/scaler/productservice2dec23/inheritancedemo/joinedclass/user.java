package com.scaler.productservice2dec23.inheritancedemo.joinedclass;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "joined_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class user {
    @Id
    private Long id;
    private String name;
    private String email;
}
