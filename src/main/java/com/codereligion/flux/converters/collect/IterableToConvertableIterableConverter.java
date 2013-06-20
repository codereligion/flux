package com.codereligion.flux.converters.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.reflect.TypeToken;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.Convertable;
import com.codereligion.flux.spi.Converter;

import javax.annotation.Nullable;
import java.lang.reflect.TypeVariable;

final class IterableToConvertableIterableConverter<T> implements Converter<Iterable<T>, Iterable<Convertable>> {

    @Nullable
    @Override
    public <V extends Iterable<T>> Iterable<Convertable> convert(V value, TypeToken<V> input, Capacitor capacitor) {
        Preconditions.checkNotNull(value, "Value");
        final TypeToken<T> token = getTypeParameterType(input);
        return Iterables.transform(value, new CapacitorFunction<T>(capacitor, token));
    }

    private <V extends Iterable<T>> TypeToken<T> getTypeParameterType(TypeToken<V> type) {
        @SuppressWarnings("rawtypes")
        final TypeVariable<Class<Iterable>>[] parameters = Iterable.class.getTypeParameters();
        final TypeToken<? super V> supertype = type.getSupertype(Iterable.class);
        return cast(supertype.resolveType(parameters[0]));
    }

    @SuppressWarnings("unchecked")
    private TypeToken<T> cast(TypeToken<?> token) {
        return (TypeToken<T>) token;
    }

}
