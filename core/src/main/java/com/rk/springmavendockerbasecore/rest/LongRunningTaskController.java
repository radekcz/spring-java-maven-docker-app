package com.rk.springmavendockerbasecore.rest;

import com.rk.springmavendockerbasecore.rest.model.AsyncTaskStatus;
import com.rk.springmavendockerbasecore.rest.model.LongRunningTaskResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping(path = "api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class LongRunningTaskController {

    private final LongRunningTaskService service;

    @PostMapping(value = "tasks")
    public LongRunningTaskResponse createLongRunningTask() {
        var taskId = service.createLongRunningTask();
        return new LongRunningTaskResponse(taskId);
    }

    @GetMapping(value = "tasks/{taskId}")
    public AsyncTaskStatus geLongRunningTaskStatus(@PathVariable String taskId) {
        return service.getLongRunningTaskStatus(taskId);
    }
}
