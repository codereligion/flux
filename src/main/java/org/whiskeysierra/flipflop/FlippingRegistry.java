package org.whiskeysierra.flipflop;

import com.google.common.base.Function;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FlippingRegistry {

    void register(Function<Object, ?> f);

    Iterable<Flippable> flip(Iterable<?> iterable);

    Collection<Flippable> flip(Collection<?> collection);

    Set<Flippable> flip(Set<?> set);

    List<Flippable> flip(List<?> list);

    <K> Map<K, Flippable> flip(Map<K, ?> map);

}
