package com.restaurant.exception;

public class NoSuitableTableException extends Exception {
    String message;

    public NoSuitableTableException(String message) {
        this.message = message;
    }
}
