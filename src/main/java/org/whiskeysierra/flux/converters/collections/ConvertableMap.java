package org.whiskeysierra.flux.converters.collections;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.Convertable;

import java.util.Map;

final class ConvertableMap<K> extends ForwardingMap<K, Convertable> {

    private final Map<K, Convertable> map;
    private final Capacitor capacitor;

    public ConvertableMap(Map<K, Convertable> map, Capacitor capacitor) {
        this.map = Preconditions.checkNotNull(map, "Map");
        this.capacitor = Preconditions.checkNotNull(capacitor, "Capacitor");
    }

    @Override
    protected Map<K, Convertable> delegate() {
        return map;
    }

    @Override
    public Convertable get(Object key) {
        final Convertable convertable = super.get(key);
        return convertable == null ? capacitor.convert(null) : convertable;
    }

}
