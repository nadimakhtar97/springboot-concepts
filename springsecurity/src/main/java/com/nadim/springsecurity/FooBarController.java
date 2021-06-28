package com.nadim.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooBarController {

    // This api requires authentication and authorization
    @GetMapping("/student")
    public String student() {
        return "hello student";
    }

    // This api requires authentication and authorization
    @GetMapping("/admin")
    public String admin() {
        return "hello admin";
    }

    // This api does not require any authentication or authorization
    @GetMapping("/visitor")
    public String visitor() {
        return "hello visitor";
    }
}
