package org.whiskeysierra.flux;

import com.google.common.base.Optional;
import com.google.common.reflect.TypeToken;

import javax.annotation.Nullable;

interface Conversion {

    <I, O> Optional<O> run(@Nullable I input, TypeToken<I> type, TypeToken<O> output);

}
