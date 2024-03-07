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

    @Async
    public void createLongRunningTask(String taskId) {
        Try.run(() -> {
            Thread.sleep(10*1000);
            log.info("Long-running task with ID: {} finished.", taskId);
        }).onFailure(e -> log.error("Cannot create a new long-running task with ID: {}", taskId, e));
    }
}
