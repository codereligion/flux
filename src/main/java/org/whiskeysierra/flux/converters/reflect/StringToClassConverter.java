package org.whiskeysierra.flux.converters.reflect;

import com.google.common.reflect.TypeToken;
import org.reflections.ReflectionUtils;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;

public final class StringToClassConverter implements Converter<String, Class<?>> {

    @Nullable
    @Override
    public <V extends String> Class<?> convert(V input, TypeToken<V> type, TypeToken<? extends Class<?>> output,
        Capacitor capacitor) {
        return ReflectionUtils.forName(input);
    }

}
