package com.vladcarcu.socialloginexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @GetMapping
    public String hello() {
        return "Hello, you've made it";
    }
}
