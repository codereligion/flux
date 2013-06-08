package org.whiskeysierra.flux;

import com.google.common.base.Optional;
import com.google.common.reflect.TypeToken;

public interface Convertable {

    Object raw();

    <T> T cast(Class<T> type);

    <T> T cast(TypeToken<T> type);

    <O> O to(Class<O> type);

    <O> O to(TypeToken<O> type);

    <O> Optional<O> tryTo(Class<O> type);

    <O> Optional<O> tryTo(TypeToken<O> type);

}
