package com.rk.springmavendockerbasecore.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class LongRunningTaskService {

    private final AsyncTaskService asyncTaskService;

    public String createLongRunningTask() {
        var taskId = UUID.randomUUID().toString();
        asyncTaskService.processTaskAsync(taskId);
        return taskId;
    }
}
