package com.rk.springmavendockerbasecore.rest;

import com.rk.springmavendockerbasecore.rest.model.AsyncTaskStatus;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.rk.springmavendockerbasecore.rest.model.AsyncTaskStatus.*;

@Slf4j
@Service
public class AsyncTaskService {

    private static final int EXECUTION_TIME_SECONDS = 10;

    private Map<String, AsyncTaskStatus> jobStatuses;

    public AsyncTaskService() {
        jobStatuses = new ConcurrentHashMap<>();
    }

    @Async
    public void processTaskAsync(String taskId) {
        jobStatuses.put(taskId, CREATED);

        Try.run(() -> {
            jobStatuses.put(taskId, STARTED);
            Thread.sleep(EXECUTION_TIME_SECONDS*1000);

            jobStatuses.put(taskId, FINISHED);
            log.info("Async task with ID: {} finished.", taskId);
        }).onFailure(e -> log.error("Cannot create Async task with ID: {}", taskId, e));
    }

    public AsyncTaskStatus getTaskStatus(String taskId) {
        return jobStatuses.getOrDefault(taskId, UNKNOWN);
    }
}
