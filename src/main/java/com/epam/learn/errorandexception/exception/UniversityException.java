package com.epam.learn.errorandexception.exception;

public class UniversityException extends Exception {
    public UniversityException() {
    }

    public UniversityException(Throwable cause) {
        super(cause);
    }

    public UniversityException(String message) {
        super(message);
    }

    public UniversityException(String message, Throwable cause) {
        super(message, cause);
    }
}
