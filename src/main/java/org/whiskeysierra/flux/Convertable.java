package org.whiskeysierra.flux;

import com.google.common.base.Optional;
import com.google.common.reflect.TypeToken;

public interface Convertable {

    <T> T to(Class<T> type);

    <T> T to(TypeToken<T> token);

    <T> Optional<T> tryTo(Class<T> type);

    <T> Optional<T> tryTo(TypeToken<T> type);

}
