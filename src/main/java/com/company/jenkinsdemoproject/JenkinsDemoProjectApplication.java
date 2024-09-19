package com.company.jenkinsdemoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinsDemoProjectApplication {

    @GetMapping("/greetings/{name}")
    public String greetingEndPoint(@PathVariable(value = "name") String name){
        return "Hello "+ name+", Congratulations, Welcome in your Jenkins-Demo endpoint";
    }

    @GetMapping("/greetings")
    public String helloEndPoint(@RequestParam(defaultValue = "Guest") String name) {
        return "Hello " + name + ", Congratulations, Welcome in your Jenkins-Hello endpoint";
    }

    public static void main(String[] args) {
        SpringApplication.run(JenkinsDemoProjectApplication.class, args);
    }

}
