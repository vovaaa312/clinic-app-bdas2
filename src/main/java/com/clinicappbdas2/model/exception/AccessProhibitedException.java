package com.clinicappbdas2.model.exception;

public class AccessProhibitedException extends RuntimeException {

    public AccessProhibitedException(String message) {
        super(message);
    }
}
