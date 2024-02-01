package com.joosal.restapi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
public class MyRestController {

    @GetMapping("/")
    public String getHomepage() {
        System.out.println("get pyyntö juureen");
        return "Welcome to REST root";
    }

    @GetMapping("/user")
    public String user(@RequestParam String username) {
        return username;
    }
    

    @PostMapping("/user")
    public String addUser(@RequestParam String username) {
        
        System.out.println("Adding user " + username);
        return "Success";
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Integer id) {
        return id.toString();
    }
    
    
    
}
