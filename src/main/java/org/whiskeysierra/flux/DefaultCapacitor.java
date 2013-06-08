package org.whiskeysierra.flux;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.internal.ConverterFinder;

import javax.annotation.Nullable;

public final class DefaultCapacitor implements Capacitor {

    private final Conversion conversion;

    public DefaultCapacitor(FeatureSet features, ConverterFinder finder) {
        Preconditions.checkNotNull(features, "Finder");
        Preconditions.checkNotNull(finder, "Mapping");

        this.conversion = new DefaultConversion(this, finder, features);
    }

    @Override
    public <O> Convertable convert(@Nullable O input) {
        if (input == null) {
            // fairly useless, because it will only allow null-to-null conversions,
            // but let's do it anyways...
            return convert(null, Void.class);
        } else {
            @SuppressWarnings("unchecked")
            final Class<Object> type = (Class<Object>) input.getClass();
            return convert(input, type);
        }
    }

    @Override
    public <I> Convertable convert(@Nullable I input, Class<I> type) {
        Preconditions.checkNotNull(type, "Type");
        return convert(input, TypeToken.of(type));
    }

    @Override
    public <I> Convertable convert(@Nullable I value, TypeToken<I> type) {
        Preconditions.checkNotNull(type, "Type");
        return new DefaultConvertable<I>(value, type, conversion);
    }

}
