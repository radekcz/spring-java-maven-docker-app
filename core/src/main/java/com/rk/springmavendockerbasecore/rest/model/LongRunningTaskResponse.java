package com.rk.springmavendockerbasecore.rest.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class LongRunningTaskResponse {

    private final String taskId;

    private final AsyncTaskStatus status;

    private final ZonedDateTime timestamp = ZonedDateTime.now();
}
