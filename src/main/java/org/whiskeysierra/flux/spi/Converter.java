package org.whiskeysierra.flux.spi;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;

import javax.annotation.Nullable;

public interface Converter<I, O> {

    @Nullable
    <V extends I> O convert(V input, TypeToken<V> type, TypeToken<? extends O> output, Capacitor capacitor);

}
