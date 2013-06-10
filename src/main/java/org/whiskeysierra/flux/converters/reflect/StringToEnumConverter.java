package org.whiskeysierra.flux.converters.reflect;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.Feature;
import org.whiskeysierra.flux.spi.Converter;
import org.whiskeysierra.flux.spi.Require;

import javax.annotation.Nullable;

@Require(Feature.SUPER_TYPING)
public final class StringToEnumConverter implements Converter<String, Enum> {

    @SuppressWarnings("unchecked")
    @Nullable
    @Override
    public <V extends String> Enum convert(V input, TypeToken<V> type, TypeToken<? extends Enum> output, Capacitor capacitor) {
        return Enum.valueOf((Class<Enum>) output.getRawType(), input);
    }

}
