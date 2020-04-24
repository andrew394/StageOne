package com.epam.learn.errorandexception.exception;

public class GroupException extends Exception {
    public GroupException() {
    }

    public GroupException(Throwable cause) {
        super(cause);
    }

    public GroupException(String message) {
        super(message);
    }

    public GroupException(String message, Throwable cause) {
        super(message, cause);
    }
}
