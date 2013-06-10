package org.whiskeysierra.flux.converters.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.Convertable;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.lang.reflect.TypeVariable;

final class IterableToConvertableIterableConverter<T> implements Converter<Iterable<T>, Iterable<Convertable>> {

    @Nullable
    @Override
    public <V extends Iterable<T>> Iterable<Convertable> convert(V input, TypeToken<V> type,
        TypeToken<? extends Iterable<Convertable>> output, final Capacitor capacitor) {

        Preconditions.checkNotNull(input, "Input");
        final TypeToken<T> token = getTypeParameterType(type);
        return Iterables.transform(input, new CapacitorFunction<T>(capacitor, token));
    }

    private <V extends Iterable<T>> TypeToken<T> getTypeParameterType(TypeToken<V> type) {
        final TypeVariable<Class<Iterable>>[] parameters = Iterable.class.getTypeParameters();
        final TypeToken<? super V> supertype = type.getSupertype(Iterable.class);
        return cast(supertype.resolveType(parameters[0]));
    }

    @SuppressWarnings("unchecked")
    private TypeToken<T> cast(TypeToken<?> token) {
        return (TypeToken<T>) token;
    }

}
