package org.whiskeysierra.flux;

import com.google.common.base.Function;
import com.google.common.base.Optional;

import javax.annotation.Nullable;

final class OptionalFunction<T> implements Function<T, Optional<T>> {

    @Override
    public Optional<T> apply(@Nullable T input) {
        return Optional.fromNullable(input);
    }

}
