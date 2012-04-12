package org.whiskeysierra.flux;

import com.google.common.base.Optional;
import com.google.common.reflect.TypeToken;

public enum NullConvertable implements Convertable {

    INSTANCE;

    @Override
    public Optional<Object> raw() {
        return Optional.absent();
    }

    @Override
    public <O> O to(Class<O> type) {
        throw new IllegalStateException();
    }

    @Override
    public <O> O to(TypeToken<O> token) {
        throw new IllegalStateException();
    }

    @Override
    public <O> Optional<O> tryTo(Class<O> type) {
        return Optional.absent();
    }

    @Override
    public <O> Optional<O> tryTo(TypeToken<O> type) {
        return Optional.absent();
    }
}
