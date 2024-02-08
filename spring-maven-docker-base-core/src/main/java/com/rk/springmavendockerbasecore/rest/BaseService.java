package com.rk.springmavendockerbasecore.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

    @Value("${app.version}")
    private String version;

    public String handleHello() {
        return "Hello from BaseService.";
    }

    public String getVersionFromProperties() {
        return version;
    }
}
