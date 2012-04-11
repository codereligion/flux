package org.whiskeysierra.flux;

import com.google.common.base.Optional;
import com.google.common.reflect.TypeToken;

public interface Convertable {

    <O> O to(Class<O> type);

    <O> O to(TypeToken<O> token);

    <O> Optional<O> tryTo(Class<O> type);

    <O> Optional<O> tryTo(TypeToken<O> type);

}
