package org.whiskeysierra.flux;

import com.google.common.reflect.TypeToken;

import javax.annotation.Nullable;

public interface Capacitor {

    <I> Convertable convert(@Nullable I input);

    <I> Convertable convert(@Nullable I input, Class<I> type);

    <I> Convertable convert(@Nullable I input, TypeToken<I> type);

}
