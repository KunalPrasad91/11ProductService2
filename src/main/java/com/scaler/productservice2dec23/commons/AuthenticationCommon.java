package com.scaler.productservice2dec23.commons;

import com.scaler.productservice2dec23.dtos.UserDto;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationCommon {
    RestTemplate restTemplate;

    @Autowired
    public AuthenticationCommon(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String token)
    {
       ResponseEntity<UserDto> response = restTemplate.postForEntity("http://localhost:8181/users/validate" + token,
                null,
                UserDto.class
                );

       if(response.getBody() == null)
           return null;

       return  response.getBody();

    }

}
