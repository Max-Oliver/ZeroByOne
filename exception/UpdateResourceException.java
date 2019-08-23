package com.art.experience.dev.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UpdateResourceException extends RuntimeException {
    public UpdateResourceException() {
        super();
    }
    public UpdateResourceException(String message, Throwable cause) {
        super(message, cause);
    }
    public UpdateResourceException(String message) {
        super(message);
    }
    public UpdateResourceException(Throwable cause) {
        super(cause);
    }
}
