package org.whiskeysierra.flux;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;

import java.util.Collection;
import java.util.Map;

public final class Tokens {

    public static final TypeToken<Iterable<Convertable>> ITERABLE =
        new TypeToken<Iterable<Convertable>>() {};

    public static final TypeToken<Collection<Convertable>> COLLECTION =
        new TypeToken<Collection<Convertable>>() {};

    public static final TypeToken<Map<?, Convertable>> MAP =
        new TypeToken<Map<?, Convertable>>() {};

    private Tokens() {

    }

    public static <K> TypeToken<Map<K, Convertable>> forMap(Class<K> type) {
        Preconditions.checkNotNull(type, "Type");
        return forMap(TypeToken.of(type));
    }

    private static <K> TypeToken<Map<K, Convertable>> forMap(TypeToken<K> type) {
        Preconditions.checkNotNull(type, "Type");

        return new TypeToken<Map<K, Convertable>>() {}.
            where(new TypeParameter<K>() {}, type);
    }

}
