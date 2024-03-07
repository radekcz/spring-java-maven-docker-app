package com.rk.springmavendockerbasecore.rest;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class AsyncTaskService {

    private static final int EXECUTION_TIME_SECONDS = 10;

    @Async
    public void processTaskAsync(String taskId) {
        Try.run(() -> {
            Thread.sleep(EXECUTION_TIME_SECONDS*1000);
            log.info("Async task with ID: {} finished.", taskId);
        }).onFailure(e -> log.error("Cannot create Async task with ID: {}", taskId, e));
    }
}
