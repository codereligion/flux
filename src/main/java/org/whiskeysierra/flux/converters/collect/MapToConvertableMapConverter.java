package org.whiskeysierra.flux.converters.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.Convertable;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.lang.reflect.TypeVariable;
import java.util.Map;

public final class MapToConvertableMapConverter<K, T> implements Converter<Map<K, T>, Map<K, Convertable>> {

    @Nullable
    @Override
    public <V extends Map<K, T>> Map<K, Convertable> convert(V input, TypeToken<V> type,
        TypeToken<? extends Map<K, Convertable>> output, final Capacitor capacitor) {
        Preconditions.checkNotNull(input, "Input");
        final TypeToken<T> token = getValueParameterType(type);
        final CapacitorFunction<T> function = new CapacitorFunction<T>(capacitor, token);
        return new ConvertableMap<K>(Maps.transformValues(input, function), capacitor);
    }

    private <V extends Map<K, T>> TypeToken<T> getValueParameterType(TypeToken<V> type) {
        final TypeVariable<Class<Map>>[] parameters = Map.class.getTypeParameters();
        final TypeToken<? super V> supertype = type.getSupertype(Map.class);
        return cast(supertype.resolveType(parameters[1]));
    }

    @SuppressWarnings("unchecked")
    private TypeToken<T> cast(TypeToken<?> token) {
        return (TypeToken<T>) token;
    }

}
