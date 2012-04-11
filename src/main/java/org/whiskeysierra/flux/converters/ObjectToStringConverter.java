package org.whiskeysierra.flux.converters;

import org.whiskeysierra.flux.Converter;

import javax.annotation.Nullable;

public final class ObjectToStringConverter implements Converter<Object, String> {

    @Override
    public String convert(@Nullable Object input) {
        return input == null ? null : input.toString();
    }

}
