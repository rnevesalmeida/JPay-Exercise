package com.jpay.configurationService.configurationService.exception;

public class ConfigurationNotFoundException extends RuntimeException {

    public ConfigurationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
