package org.whiskeysierra.flux;

import com.google.common.base.Function;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ConvertableFactory extends Function<Object, Convertable> {

    Iterable<Convertable> transform(@Nonnull Iterable<?> iterable);

    Collection<Convertable> transform(@Nonnull Collection<?> collection);

    List<Convertable> transform(@Nonnull List<?> list);

    <K> Map<K, Convertable> transform(@Nonnull Map<K, ?> map);

}
