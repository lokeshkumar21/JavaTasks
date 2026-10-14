package com;

public class ErrorMessage {
    private String code;
    private String message;
    private String additionalInformation;

    public ErrorMessage(String code, String message, String additionalInformation) {
        this.code = code;
        this.message = message;
        this.additionalInformation = additionalInformation;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }
}