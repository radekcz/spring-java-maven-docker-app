package com.rk.springmavendockerbasecore.rest;

import com.rk.springmavendockerbasecore.rest.model.Profile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping(path = "api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class BaseController {

    private final BaseService baseService;

    @GetMapping(value = "ping")
    public String ping() {
        log.info("Hello from /api/ping.");
        return baseService.handlePing();
    }

    @GetMapping(value = "profile")
    public Profile getProfile() {
        return baseService.getProfile();
    }

    @PostMapping(value = "profile")
    public void setProfile(@RequestParam Profile profile) {
        baseService.setProfile(profile);
    }

    @GetMapping(value = "version")
    public String getVersion() {
        return baseService.getVersionFromProperties();
    }
}
