package org.whiskeysierra.flux;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class DefaultConvertableFactory implements ConvertableFactory {

    private final ConverterMapping mapping;

    private final Function<Object, Convertable> function = new Function<Object, Convertable>() {

        @Override
        public Convertable apply(@Nullable Object input) {
            return transform(input);
        }

    };

    public DefaultConvertableFactory(ConverterMapping mapping) {
        this.mapping = mapping;
    }

    @Override
    public Convertable transform(@Nullable Object input) {
        if (input == null) {
            return NullConvertable.INSTANCE;
        } else {
            return new DefaultConvertable(mapping, input);
        }
    }

    @Override
    public Iterable<Convertable> transform(@Nonnull Iterable<?> iterable) {
        return Iterables.transform(iterable, function);
    }

    @Override
    public Collection<Convertable> transform(@Nonnull Collection<?> collection) {
        return Collections2.transform(collection, function);
    }

    @Override
    public List<Convertable> transform(@Nonnull List<?> list) {
        return Lists.transform(list, function);
    }

    @Override
    public <K> Map<K, Convertable> transform(@Nonnull Map<K, ?> map) {
        return new ConvertableMap<K>(Maps.transformValues(map, function));
    }

}
