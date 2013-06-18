package org.whiskeysierra.flux.converters.reflect;

import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;
import org.whiskeysierra.flux.spi.Dependency;

import javax.annotation.Nullable;

@Dependency(input = String.class, output = Class.class)
@SuppressWarnings("rawtypes")
public final class StringToTypeTokenConverter implements Converter<String, TypeToken> {

    @Nullable
    @Override
    public <V extends String> TypeToken convert(V value, TypeToken<V> input, Capacitor capacitor) {
        final Class<?> type = capacitor.convert(value).to(Class.class);
        return TypeToken.of(type);
    }

}
