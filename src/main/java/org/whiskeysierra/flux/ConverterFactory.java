package org.whiskeysierra.flux;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ConverterFactory {

    Iterable<Convertable> flip(Iterable<?> iterable);

    Collection<Convertable> flip(Collection<?> collection);

    Set<Convertable> flip(Set<?> set);

    List<Convertable> flip(List<?> list);

    <K> Map<K, Convertable> flip(Map<K, ?> map);

}
