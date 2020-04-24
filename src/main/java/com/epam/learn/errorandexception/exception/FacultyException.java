package com.epam.learn.errorandexception.exception;

public class FacultyException extends Exception {
    public FacultyException() {
    }

    public FacultyException(Throwable cause) {
        super(cause);
    }

    public FacultyException(String message) {
        super(message);
    }

    public FacultyException(String message, Throwable cause) {
        super(message, cause);
    }
}
