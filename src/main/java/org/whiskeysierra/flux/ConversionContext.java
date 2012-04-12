package org.whiskeysierra.flux;

public interface ConversionContext {

    void post(String message, Object first);

    void post(String message, Object first, Object second);

    void post(String message, Object... args);

}
