package com.epam.aircompany.exception;

public class MilitaryPlaneException extends Exception {
    public MilitaryPlaneException() {
    }

    public MilitaryPlaneException(Throwable cause) {
        super(cause);
    }

    public MilitaryPlaneException(String message) {
        super(message);
    }

    public MilitaryPlaneException(String message, Throwable cause) {
        super(message, cause);
    }

}