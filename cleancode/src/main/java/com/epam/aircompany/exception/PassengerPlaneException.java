package com.epam.aircompany.exception;

public class PassengerPlaneException extends Exception {
    public PassengerPlaneException() {
    }

    public PassengerPlaneException(Throwable cause) {
        super(cause);
    }

    public PassengerPlaneException(String message) {
        super(message);
    }

    public PassengerPlaneException(String message, Throwable cause) {
        super(message, cause);
    }

}