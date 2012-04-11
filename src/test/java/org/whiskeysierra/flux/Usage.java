package org.whiskeysierra.flux;

import java.util.Map;

public final class Usage {

    public void test() {
        ConverterFactory registry = null;
        final Map<String, Object> original = null;

        final Map<String, Convertable> map = registry.flip(original);

        map.get("key").to(Long.class);
        map.get("key").tryTo(Long.class).get();
        map.get("key").tryTo(Long.class).orNull();
        map.get("key").tryTo(Long.class).or(1L);
    }

}
