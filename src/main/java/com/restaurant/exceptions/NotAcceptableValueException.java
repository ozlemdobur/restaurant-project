package com.restaurant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE)
public class NotAcceptableValueException extends RuntimeException{

    public NotAcceptableValueException() {
    }

    public NotAcceptableValueException(String message) {
        super(message);
    }

    public NotAcceptableValueException(Throwable cause) {
        super(cause);
    }
}
