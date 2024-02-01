package com.joosal.restapi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class MyRestController {

    @GetMapping("/")
    public String getHomepage() {
        return "Welcome to REST root";
    }
    
}
