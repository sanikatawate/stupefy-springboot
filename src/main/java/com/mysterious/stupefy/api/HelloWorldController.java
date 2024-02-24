package com.mysterious.stupefy.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class HelloWorldController {

    @GetMapping
    public String hello(){
        return "Hello World";
    }
}
