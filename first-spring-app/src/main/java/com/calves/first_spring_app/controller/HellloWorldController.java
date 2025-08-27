package com.calves.first_spring_app.controller;

import com.calves.first_spring_app.domain.User;
import com.calves.first_spring_app.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-world")
public class HellloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    /*public HellloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }*/


    @GetMapping
    public String helloWorld(){
        return helloWorldService.helloWorld("TEST");
    }

    @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable("id") String id, @RequestBody User body) {
        return "Hello World " + body.getName() + id;
    }
}
