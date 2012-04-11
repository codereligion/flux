package org.whiskeysierra.flux;

import com.google.common.collect.ForwardingMap;

import java.util.Map;

final class ConvertableMap<K> extends ForwardingMap<K, Convertable>{

    private final Map<K, Convertable> map;

    public ConvertableMap(Map<K, Convertable> map) {
        this.map = map;
    }

    @Override
    protected Map<K, Convertable> delegate() {
        return map;
    }

    @Override
    public boolean containsKey(Object key) {
        return true;
    }

    @Override
    public Convertable get(Object key) {
        final Convertable convertable = super.get(key);

        if (convertable == null) {
            return NullConvertable.INSTANCE;
        } else {
            return convertable;
        }
    }

}
