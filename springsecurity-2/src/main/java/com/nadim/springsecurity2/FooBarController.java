package com.nadim.springsecurity2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooBarController {


    @GetMapping("/visitor")
    public String visitor() {
        return "<h1>Hello Visitor</h1>";
    }

    @GetMapping("/admin")
    public String admin() {
        return "<h1>Hello Admin</h1>";
    }

    @GetMapping("/student")
    public String student() {
        return "<h1>Hello student</h1>";
    }


}
