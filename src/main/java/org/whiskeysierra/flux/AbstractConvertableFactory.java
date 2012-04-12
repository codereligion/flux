package org.whiskeysierra.flux;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class AbstractConvertableFactory implements ConvertableFactory {

    @Override
    public Iterable<Convertable> transform(@Nonnull Iterable<?> iterable) {
        return Iterables.transform(iterable, this);
    }

    @Override
    public Collection<Convertable> transform(@Nonnull Collection<?> collection) {
        return Collections2.transform(collection, this);
    }

    @Override
    public List<Convertable> transform(@Nonnull List<?> list) {
        return Lists.transform(list, this);
    }

    @Override
    public <K> Map<K, Convertable> transform(@Nonnull Map<K, ?> map) {
        return new DefaultedMap<K, Convertable>(Maps.transformValues(map, this), NullConvertable.INSTANCE);
    }

}
