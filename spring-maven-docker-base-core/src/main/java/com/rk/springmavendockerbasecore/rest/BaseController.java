package com.rk.springmavendockerbasecore.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping(path = "api", produces = MediaType.APPLICATION_JSON_VALUE)
public class BaseController {

    private final BaseService baseService;

    @GetMapping(value = "ping")
    public String hello() {
        log.info("Hello from /api/ping.");
        return baseService.handleHello();
    }
}
