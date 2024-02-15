package com.rk.springmavendockerbasecore.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping(path = "api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class K8sResourceController {

    private final K8sResourceService k8sResourceService;

    @GetMapping(value = "pods")
    public List<String> listPods(@RequestParam(required = false) String namespace) {
        return k8sResourceService.getPods(namespace);
    }
}
