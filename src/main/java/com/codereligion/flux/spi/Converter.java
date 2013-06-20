package com.codereligion.flux.spi;

import com.codereligion.flux.Capacitor;
import com.google.common.reflect.TypeToken;

import javax.annotation.Nullable;

public interface Converter<I, O> {

    @Nullable
    <V extends I> O convert(V value, TypeToken<V> input, Capacitor capacitor);

}
