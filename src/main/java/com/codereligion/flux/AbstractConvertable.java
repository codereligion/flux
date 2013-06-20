package com.codereligion.flux;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;

abstract class AbstractConvertable implements Convertable {

    @Override
    public <T> T cast(Class<T> type) {
        Preconditions.checkNotNull(type, "Type");
        return type.cast(raw());
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T cast(TypeToken<T> type) {
        Preconditions.checkNotNull(type, "Type");
        return (T) type.getRawType().cast(raw());
    }

    @Override
    public <O> O to(Class<O> type) {
        Preconditions.checkNotNull(type, "Type");
        return to(TypeToken.of(type));
    }

    @Override
    public <O> O to(TypeToken<O> type) {
        Preconditions.checkNotNull(type, "Type");
        return tryTo(type).get();
    }

    @Override
    public <O> Optional<O> tryTo(Class<O> type) {
        Preconditions.checkNotNull(type, "Type");
        return tryTo(TypeToken.of(type));
    }

}
