package org.whiskeysierra.flux.converters.collections;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.Convertable;

import javax.annotation.Nullable;

final class CapacitorFunction<T> implements Function<T, Convertable> {

    private final Capacitor capacitor;
    private final TypeToken<T> output;

    CapacitorFunction(Capacitor capacitor, TypeToken<T> output) {
        this.capacitor = Preconditions.checkNotNull(capacitor, "Capacitor");
        this.output = Preconditions.checkNotNull(output, "Output");
    }

    @Override
    public Convertable apply(@Nullable T input) {
        return capacitor.convert(input, output);
    }

}
