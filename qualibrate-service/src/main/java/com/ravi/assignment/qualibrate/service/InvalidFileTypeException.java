package com.ravi.assignment.qualibrate.service;

public class InvalidFileTypeException extends RuntimeException {

    private static final long serialVersionUID = -2903625893037363581L;

    public InvalidFileTypeException(String message) {

        super(message);
    }
}
