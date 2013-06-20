package com.codereligion.flux;

public final class UnknownConversionException extends RuntimeException {

    private static final long serialVersionUID = 1;

    public UnknownConversionException(String message) {
        super(message);
    }

    public UnknownConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownConversionException(Throwable cause) {
        super(cause);
    }

}
