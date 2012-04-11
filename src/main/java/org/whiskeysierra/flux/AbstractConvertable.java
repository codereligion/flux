package org.whiskeysierra.flux;

import com.google.common.base.Optional;
import com.google.common.reflect.TypeToken;

public abstract class AbstractConvertable implements Convertable {

    public <T> T to(Class<T> type) {
        return to(TypeToken.of(type));
    }

    public <T> Optional<T> tryTo(Class<T> type) {
        return tryTo(TypeToken.of(type));
    }

}
