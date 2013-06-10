package org.whiskeysierra.flux.internal;

import com.google.common.base.Preconditions;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Bundle;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.ConversionException;
import org.whiskeysierra.flux.spi.Converter;

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
