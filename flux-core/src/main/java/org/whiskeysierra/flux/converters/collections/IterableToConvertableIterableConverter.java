package org.whiskeysierra.flux.converters.collections;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.Convertable;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.lang.reflect.TypeVariable;

final class IterableToConvertableIterableConverter<I> implements Converter<Iterable<I>, Iterable<Convertable>> {

    @Nullable
    @Override
    public <V extends Iterable<I>> Iterable<Convertable> convert(V input, TypeToken<V> type,
            final Capacitor capacitor) {

        Preconditions.checkNotNull(input, "Input");

        final TypeToken<I> token = getTypeParameterToken(type);

        return Iterables.transform(input, new Function<I, Convertable>() {

            @Override
            public Convertable apply(@Nullable I input) {
                return capacitor.convert(input, token);
            }

        });
    }

    private <V extends Iterable<I>> TypeToken<I> getTypeParameterToken(TypeToken<V> type) {
        final TypeVariable<Class<Iterable>>[] parameters = Iterable.class.getTypeParameters();
        final TypeToken<? super V> supertype = type.getSupertype(Iterable.class);
        return cast(supertype.resolveType(parameters[0]));
    }

    @SuppressWarnings("unchecked")
    private TypeToken<I> cast(TypeToken<?> token) {
        return (TypeToken<I>) token;
    }

}
