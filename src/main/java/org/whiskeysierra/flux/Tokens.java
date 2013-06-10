package org.whiskeysierra.flux;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class Tokens {

    public static final class Wildcard {

        public static final TypeToken<Iterable<?>> ITERABLE = new TypeToken<Iterable<?>>() {};
        public static final TypeToken<Collection<?>> COLLECTION = new TypeToken<Collection<?>>() {};
        public static final TypeToken<List<?>> LIST = new TypeToken<List<?>>() {};
        public static final TypeToken<Map<?, ?>> MAP = new TypeToken<Map<?, ?>>() {};

        private Wildcard() {

        }

    }

    private Tokens() {

    }

    public static <E> TypeToken<Iterable<E>> forIterable(Class<E> elementType) {
        Preconditions.checkNotNull(elementType, "ElementType");
        return forIterable(TypeToken.of(elementType));
    }

    public static <E> TypeToken<Iterable<E>> forIterable(TypeToken<E> elementType) {
        Preconditions.checkNotNull(elementType, "ElementType");
        return new TypeToken<Iterable<E>>() {}.
            where(new TypeParameter<E>() {}, elementType);
    }

    public static <E> TypeToken<List<E>> forList(Class<E> elementType) {
        Preconditions.checkNotNull(elementType, "ElementType");
        return forList(TypeToken.of(elementType));
    }

    public static <E> TypeToken<List<E>> forList(TypeToken<E> elementType) {
        Preconditions.checkNotNull(elementType, "ElementType");
        return new TypeToken<List<E>>() {}.
            where(new TypeParameter<E>() {}, elementType);
    }

    public static <K> TypeToken<Map<K, Convertable>> forMap(Class<K> keyType) {
        Preconditions.checkNotNull(keyType, "KeyType");
        return forMap(keyType, Convertable.class);
    }

    public static <K, V> TypeToken<Map<K, V>> forMap(Class<K> keyType, Class<V> valueType) {
        Preconditions.checkNotNull(keyType, "KeyType");
        Preconditions.checkNotNull(valueType, "ValueType");
        return forMap(TypeToken.of(keyType), TypeToken.of(valueType));
    }

    public static <K, V> TypeToken<Map<K, V>> forMap(TypeToken<K> keyType, TypeToken<V> valueType) {
        Preconditions.checkNotNull(keyType, "KeyType");
        Preconditions.checkNotNull(valueType, "ValueType");
        return new TypeToken<Map<K, V>>() {}.
            where(new TypeParameter<K>() {}, keyType).
            where(new TypeParameter<V>() {}, valueType);
    }

}
