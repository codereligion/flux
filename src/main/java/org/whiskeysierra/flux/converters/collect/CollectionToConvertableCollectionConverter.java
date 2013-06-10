package org.whiskeysierra.flux.converters.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.Convertable;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;
import java.lang.reflect.TypeVariable;
import java.util.Collection;

final class CollectionToConvertableCollectionConverter<T> implements Converter<Collection<T>, Collection<Convertable>> {

    @Nullable
    @Override
    public <V extends Collection<T>> Collection<Convertable> convert(V value, TypeToken<V> input, Capacitor capacitor) {
        Preconditions.checkNotNull(value, "Value");
        final TypeToken<T> token = getTypeParameterType(input);
        return Collections2.transform(value, new CapacitorFunction<T>(capacitor, token));
    }

    private <V extends Collection<T>> TypeToken<T> getTypeParameterType(TypeToken<V> type) {
        final TypeVariable<Class<Collection>>[] parameters = Collection.class.getTypeParameters();
        final TypeToken<? super V> supertype = type.getSupertype(Collection.class);
        return cast(supertype.resolveType(parameters[0]));
    }

    @SuppressWarnings("unchecked")
    private TypeToken<T> cast(TypeToken<?> token) {
        return (TypeToken<T>) token;
    }

}
