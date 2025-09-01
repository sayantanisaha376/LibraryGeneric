package com.example.exception;



import lombok.Getter;

import java.time.Instant;

@Getter
public class ErrorDetails {
    private final Instant timestamp = Instant.now();
    private final int status;
    private final String error;
    private final String message;
    private final String path;

    public ErrorDetails(int status, String error, String message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

}
