package com.rk.springmavendockerbasecore.rest;

import com.rk.springmavendockerbasecore.rest.model.LongRunningTaskResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.rk.springmavendockerbasecore.rest.model.AsyncTaskStatus.CREATED;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping(path = "api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class LongRunningTaskController {

    private final LongRunningTaskService service;

    @PostMapping(value = "tasks")
    public LongRunningTaskResponse createLongRunningTask() {
        var taskId = service.createLongRunningTask();
        return new LongRunningTaskResponse(taskId, CREATED);
    }

    @GetMapping(value = "tasks/{taskId}")
    public LongRunningTaskResponse geLongRunningTaskStatus(@PathVariable String taskId) {
        var status = service.getLongRunningTaskStatus(taskId);
        return new LongRunningTaskResponse(taskId, status);
    }
}
