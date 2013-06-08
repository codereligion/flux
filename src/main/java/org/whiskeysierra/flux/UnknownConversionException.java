package org.whiskeysierra.flux;

public final class UnknownConversionException extends RuntimeException {

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
