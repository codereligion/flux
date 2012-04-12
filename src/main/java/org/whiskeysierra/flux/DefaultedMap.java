package org.whiskeysierra.flux;

import com.google.common.base.Objects;
import com.google.common.collect.ForwardingMap;

import java.util.Map;

final class DefaultedMap<K, V> extends ForwardingMap<K, V> {

    private final Map<K, V> map;
    private final V defaultValue;

    public DefaultedMap(Map<K, V> map, V defaultValue) {
        this.map = map;
        this.defaultValue = defaultValue;
    }

    @Override
    protected Map<K, V> delegate() {
        return map;
    }

    @Override
    public V get(Object key) {
        return Objects.firstNonNull(super.get(key), defaultValue);
    }

}
