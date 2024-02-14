package com.scaler.productservice2dec23.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;




@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private String phonenumber;
    private String address;
    private Boolean isEmailVerified;
    private List<Role> roles;
}