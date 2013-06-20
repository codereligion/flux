package com.codereligion.flux;

public final class ConfigurationException extends RuntimeException {

    private static final long serialVersionUID = 1;

    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConfigurationException(Throwable cause) {
        super(cause);
    }

}
