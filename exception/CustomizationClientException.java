package com.art.experience.dev.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FAILED_DEPENDENCY)
public class CustomizationClientException extends RuntimeException {
    public CustomizationClientException() {
        super();
    }
    public CustomizationClientException(String message, Throwable cause) {
        super(message, cause);
    }
    public CustomizationClientException(String message) {
        super(message);
    }
    public CustomizationClientException(Throwable cause) {
        super(cause);
    }
}
