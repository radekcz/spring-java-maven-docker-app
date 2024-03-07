package com.rk.springmavendockerbasecore.rest;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LongRunningTaskService {

    private static final int EXECUTION_TIME_SECONDS = 10;

    @Async
    public void createLongRunningTask(String taskId) {
        Try.run(() -> {
            Thread.sleep(EXECUTION_TIME_SECONDS*1000);
            log.info("Long-running task with ID: {} finished.", taskId);
        }).onFailure(e -> log.error("Cannot create a new long-running task with ID: {}", taskId, e));
    }
}
