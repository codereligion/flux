package org.whiskeysierra.flux;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ConvertableFactory {

    Convertable transform(@Nullable Object input);

    Iterable<Convertable> transform(@Nonnull Iterable<?> iterable);

    Collection<Convertable> transform(@Nonnull Collection<?> collection);

    List<Convertable> transform(@Nonnull List<?> list);

    <K> Map<K, Convertable> transform(@Nonnull Map<K, ?> map);

}
