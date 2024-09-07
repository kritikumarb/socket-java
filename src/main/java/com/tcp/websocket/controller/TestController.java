package com.tcp.websocket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // Base path for this controller
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "Test endpoint";
    }
}
