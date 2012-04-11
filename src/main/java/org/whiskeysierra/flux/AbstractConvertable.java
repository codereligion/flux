package org.whiskeysierra.flux;

import com.google.common.base.Optional;
import com.google.common.reflect.TypeToken;

public abstract class AbstractConvertable implements Convertable {

    @Override
    public <O> O to(Class<O> type) {
        return to(TypeToken.of(type));
    }

    @Override
    public <O> O to(TypeToken<O> output) {
        return tryTo(output).get();
    }

    @Override
    public <O> Optional<O> tryTo(Class<O> type) {
        return tryTo(TypeToken.of(type));
    }

}
