package org.whiskeysierra.flux.converters.wrappers;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

public final class StringToFloatConverter implements Converter<String, Float> {

    @Override
    public <V extends String> Float convert(V input, TypeToken<V> type, TypeToken<? extends Float> output, Capacitor capacitor) {
        Preconditions.checkNotNull(input, "Input");
        return Float.valueOf(input);
    }

}
