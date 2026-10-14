package com;

public class CustomException extends Exception {

    private final ErrorMessage errorMessage;

    public CustomException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}