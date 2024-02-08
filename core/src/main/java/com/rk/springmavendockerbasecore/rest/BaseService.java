package com.rk.springmavendockerbasecore.rest;

import com.rk.springmavendockerbasecore.rest.model.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BaseService {

    private final ApplicationProperties applicationProperties;

    public String handlePing() {
        return "Hello from BaseService";
    }

    public String getVersionFromProperties() {
        return applicationProperties.getVersion();
    }
}
