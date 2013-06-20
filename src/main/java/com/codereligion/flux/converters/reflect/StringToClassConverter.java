package com.codereligion.flux.converters.reflect;

import com.google.common.reflect.TypeToken;
import org.reflections.ReflectionUtils;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.spi.Converter;

import javax.annotation.Nullable;

@SuppressWarnings("rawtypes")
public final class StringToClassConverter implements Converter<String, Class> {

    @Nullable
    @Override
    public <V extends String> Class convert(V value, TypeToken<V> input, Capacitor capacitor) {
        return ReflectionUtils.forName(value);
    }

}
