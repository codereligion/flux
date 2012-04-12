package org.whiskeysierra.flux;

import com.google.common.base.Function;

import javax.annotation.Nullable;

public interface ConvertableFactory {

    Convertable transform(@Nullable Object input);

    Function<Object, Convertable> asFunction();

}
