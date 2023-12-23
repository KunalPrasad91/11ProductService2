package com.scaler.productservice2dec23.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hi")
public class HiController {

    @GetMapping("/greet")
    public String greet()
    {
        return "Hi how are you Kunal, I am good, good to hear";
    }

    @GetMapping("/greet/{user}/{times}")
    public String greetUser(@PathVariable("user") String user,
                            @PathVariable("times") int times)
    {
        String greetMsg = "";

        for (int i = 0; i < times ; i++)
        {
            greetMsg += "Wassup " + user;
            //greetMsg +="<br>";
            greetMsg +="\n";
        }

        return greetMsg;
    }

}
