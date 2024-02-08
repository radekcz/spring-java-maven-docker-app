package com.rk.springmavendockerbasecore.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class BaseController {

    @GetMapping(value = "hello")
    public String hello() {
        log.info("Hello from /api/hello.");
        return "hello";
    }
}
