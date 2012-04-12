package org.whiskeysierra.flux;

public enum NoopConversionContext implements ConversionContext {

    INSTANCE;

    @Override
    public void post(String message, Object first) {

    }

    @Override
    public void post(String message, Object first, Object second) {

    }

    @Override
    public void post(String message, Object... args) {

    }

}
