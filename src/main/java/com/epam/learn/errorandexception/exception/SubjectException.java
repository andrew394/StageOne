package com.epam.learn.errorandexception.exception;

public class SubjectException extends Exception {
    public SubjectException() {
    }

    public SubjectException(Throwable cause) {
        super(cause);
    }

    public SubjectException(String message) {
        super(message);
    }

    public SubjectException(String message, Throwable cause) {
        super(message, cause);
    }
}
