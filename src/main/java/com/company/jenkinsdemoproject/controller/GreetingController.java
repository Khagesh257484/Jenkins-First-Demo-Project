package com.company.jenkinsdemoproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping({"/greeting", "/greeting/{name}"})
    public String greeting(@PathVariable(required = false) String name) {
        if (name == null) {
            name = "Guest";
        }
        return "Hello " + name + ", Congratulations, Welcome in your Jenkins-Demo endpoint";
    }
}
