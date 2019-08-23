package com.art.experience.dev.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CreateResourceException extends RuntimeException {
    public CreateResourceException() {
        super();
    }
    public CreateResourceException(String message, Throwable cause) {
        super(message, cause);
    }
    public CreateResourceException(String message) {
        super(message);
    }
    public CreateResourceException(Throwable cause) {
        super(cause);
    }
}
