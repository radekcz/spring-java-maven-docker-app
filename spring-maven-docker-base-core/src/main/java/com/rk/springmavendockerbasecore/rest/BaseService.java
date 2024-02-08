package com.rk.springmavendockerbasecore.rest;

import com.rk.springmavendockerbasecore.rest.model.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BaseService {

    private final ApplicationProperties applicationProperties;

    public String handleHello() {
        return "Hello from BaseService.";
    }

    public String getVersionFromProperties() {
        return applicationProperties.getVersion();
    }
}
