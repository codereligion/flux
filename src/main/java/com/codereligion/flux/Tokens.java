package com.codereligion.flux;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class Tokens {

    public static final class Wildcard {

        public static final TypeToken<Iterable<?>> ITERABLE = new TypeToken<Iterable<?>>() {

            private static final long serialVersionUID = 1;

        };

        public static final TypeToken<Collection<?>> COLLECTION = new TypeToken<Collection<?>>() {

            private static final long serialVersionUID = 1;

        };

        public static final TypeToken<List<?>> LIST = new TypeToken<List<?>>() {

            private static final long serialVersionUID = 1;

        };

        public static final TypeToken<Map<?, ?>> MAP = new TypeToken<Map<?, ?>>() {

            private static final long serialVersionUID = 1;
        };

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

        final TypeToken<Iterable<E>> token = new TypeToken<Iterable<E>>() {

            private static final long serialVersionUID = 1;

        };

        return token.where(new TypeParameter<E>() {}, elementType);
    }

    public static <E> TypeToken<List<E>> forList(Class<E> elementType) {
        Preconditions.checkNotNull(elementType, "ElementType");
        return forList(TypeToken.of(elementType));
    }

    public static <E> TypeToken<List<E>> forList(TypeToken<E> elementType) {
        Preconditions.checkNotNull(elementType, "ElementType");

        final TypeToken<List<E>> token = new TypeToken<List<E>>() {

            private static final long serialVersionUID = 1;

        };

        return token.where(new TypeParameter<E>() {}, elementType);
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

        final TypeToken<Map<K, V>> token = new TypeToken<Map<K, V>>() {

            private static final long serialVersionUID = 1;

        };

        return token.
            where(new TypeParameter<K>() {
            }, keyType).
            where(new TypeParameter<V>() {}, valueType);
    }

}
