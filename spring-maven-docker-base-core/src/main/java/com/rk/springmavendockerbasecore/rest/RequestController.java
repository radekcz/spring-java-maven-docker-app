package com.rk.springmavendockerbasecore.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RequestController {

    @GetMapping(value = "hello")
    public String hello() {
        return "hello";
    }
}
