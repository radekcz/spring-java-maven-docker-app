package com.rk.springmavendockerbasecore.rest;

import com.rk.springmavendockerbasecore.rest.model.ApplicationProperties;
import com.rk.springmavendockerbasecore.rest.model.Profile;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BaseService {

    private final ApplicationProperties applicationProperties;

    @Setter @Getter
    private Profile profile = Profile.DEV;

    public String handlePing() {
        return "Hello from BaseService";
    }

    public String getVersionFromProperties() {
        return applicationProperties.getVersion();
    }
}
