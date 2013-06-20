package com.codereligion.flux;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import com.codereligion.flux.internal.ConverterFinder;

import javax.annotation.Nullable;

public final class DefaultCapacitor implements Capacitor {

    private final Conversion conversion;

    public DefaultCapacitor(FeatureSet features, ConverterFinder finder) {
        Preconditions.checkNotNull(features, "Finder");
        Preconditions.checkNotNull(finder, "Mapping");

        this.conversion = new DefaultConversion(this, finder, features);
    }

    @Override
    public <O> Convertable convert(@Nullable O value) {
        if (value == null) {
            // fairly useless, because it will only allow null-to-null conversions,
            // but let's do it anyways...
            return convert(null, Void.class);
        } else {
            @SuppressWarnings("unchecked")
            final Class<Object> type = (Class<Object>) value.getClass();
            return convert(value, type);
        }
    }

    @Override
    public <I> Convertable convert(@Nullable I value, Class<I> input) {
        Preconditions.checkNotNull(input, "Input");
        return convert(value, TypeToken.of(input));
    }

    @Override
    public <I> Convertable convert(@Nullable I value, TypeToken<I> input) {
        Preconditions.checkNotNull(input, "Input");
        return new DefaultConvertable<I>(value, input, conversion);
    }

}
