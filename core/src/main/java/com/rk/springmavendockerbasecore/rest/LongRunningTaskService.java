package com.rk.springmavendockerbasecore.rest;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class LongRunningTaskService {

    public void createLongRunningTask(String taskId) {
        Try.run(() -> Thread.sleep(10*1000))
                .onFailure(e -> log.error("Cannot create a new long-running task with ID: {}", taskId, e));
    }
}
