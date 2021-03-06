package com.codereligion.flux.converters.collect;

import com.codereligion.flux.Capacitor;
import com.codereligion.flux.Convertable;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;
import com.codereligion.flux.spi.Converter;

import javax.annotation.Nullable;
import java.lang.reflect.TypeVariable;
import java.util.List;

final class ListToConvertableListConverter<T> implements Converter<List<T>, List<Convertable>> {

    @Nullable
    @Override
    public <V extends List<T>> List<Convertable> convert(V value, TypeToken<V> input, Capacitor capacitor) {
        Preconditions.checkNotNull(value, "Value");
        final TypeToken<T> token = getTypeParameterType(input);
        return Lists.transform(value, new CapacitorFunction<T>(capacitor, token));
    }

    private <V extends List<T>> TypeToken<T> getTypeParameterType(TypeToken<V> type) {
        @SuppressWarnings("rawtypes")
        final TypeVariable<Class<List>>[] parameters = List.class.getTypeParameters();
        final TypeToken<? super V> supertype = type.getSupertype(List.class);
        return cast(supertype.resolveType(parameters[0]));
    }

    @SuppressWarnings("unchecked")
    private TypeToken<T> cast(TypeToken<?> token) {
        return (TypeToken<T>) token;
    }

}
