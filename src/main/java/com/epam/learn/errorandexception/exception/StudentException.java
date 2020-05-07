package com.epam.learn.errorandexception.exception;

public class StudentException extends Exception {
    public StudentException() {
    }

    public StudentException(Throwable cause) {
        super(cause);
    }

    public StudentException(String message) {
        super(message);
    }

    public StudentException(String message, Throwable cause) {
        super(message, cause);
    }
}
