package org.whiskeysierra.flux;

public final class ConversionException extends RuntimeException {

    private static final long serialVersionUID = 1;

    public ConversionException(String message) {
        super(message);
    }

    public ConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConversionException(Throwable cause) {
        super(cause);
    }

}
