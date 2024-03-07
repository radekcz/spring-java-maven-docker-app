package com.rk.springmavendockerbasecore.rest;

import com.rk.springmavendockerbasecore.rest.model.LongRunningTaskResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping(path = "api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class LongRunningTaskController {

    private final LongRunningTaskService service;

    @PostMapping(value = "tasks")
    public LongRunningTaskResponse createLongRunningTask() {
        var taskId = UUID.randomUUID().toString();
        service.createLongRunningTask(taskId);
        return new LongRunningTaskResponse(taskId);
    }
}
