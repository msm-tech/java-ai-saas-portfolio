package com.portfolio.firstapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AppController {

    // Home endpoint
    @GetMapping("/")
    public String home() {
        return "\uD83D\uDE80 API is running successfully! (v1)";
    }

    // Health check endpoint
    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    // Example business endpoint
    @GetMapping("/hello")
    public String sayHello(@RequestParam(defaultValue = "World") String name) {
        return "Hello " + name + "! This is my first deployed API.";
    }

    @GetMapping("/crash")
    public int crash() {
        return  10 / 0;
    }

}
