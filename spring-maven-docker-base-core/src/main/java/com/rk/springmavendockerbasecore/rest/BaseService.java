package com.rk.springmavendockerbasecore.rest;

import org.springframework.stereotype.Service;

@Service
public class BaseService {

    public String handleHello() {
        return "Hello from BaseService.";
    }
}
