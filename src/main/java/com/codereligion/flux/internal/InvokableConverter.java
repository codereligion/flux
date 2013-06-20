package com.codereligion.flux.internal;

import com.codereligion.flux.Bundle;
import com.google.common.base.Preconditions;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeToken;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.ConversionException;
import com.codereligion.flux.spi.Converter;

import javax.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;

final class InvokableConverter implements Converter<Object, Object> {

    private final Bundle bundle;
    private final Invokable<Bundle, Object> invokable;

    public InvokableConverter(Bundle bundle, Invokable<Bundle, Object> invokable) {
        this.bundle = Preconditions.checkNotNull(bundle, "Bundle");
        this.invokable = Preconditions.checkNotNull(invokable, "Invokable");
    }

    @Nullable
    @Override
    public <V extends Object> Object convert(V value, TypeToken<V> input, Capacitor capacitor) {
        try {
            return invokable.invoke(bundle, value);
        } catch (InvocationTargetException e) {
            throw new ConversionException(e);
        } catch (IllegalAccessException e) {
            throw new ConversionException(e);
        }
    }

}
