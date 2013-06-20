package com.codereligion.flux.internal;

import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import com.codereligion.flux.Feature;
import com.codereligion.flux.FeatureSet;
import com.codereligion.flux.spi.Converter;

public abstract class AbstractConverterFinder implements ConverterFinder {

    private final FeatureSet features;

    protected AbstractConverterFinder(FeatureSet features) {
        this.features = Preconditions.checkNotNull(features, "Features");
    }

    @Override
    public <I, O> Converter<I, O> search(Class<I> input, Class<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        return search(TypeToken.of(input), TypeToken.of(output));
    }

    @Override
    public <I, O> Converter<I, O> search(Class<I> input, TypeToken<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        return search(TypeToken.of(input), output);
    }

    @Override
    public <I, O> Converter<I, O> search(TypeToken<I> input, Class<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");
        return search(input, TypeToken.of(output));
    }

    @Override
    public <I, O> Converter<I, O> search(TypeToken<I> input, TypeToken<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");

        if (features.contains(Feature.SUB_TYPING)) {
            for (TypeToken<? super I> type : input.getTypes()) {
                final Converter<I, O> converter = find(type, output);
                if (converter != null) {
                    return converter;
                }
            }

            return null;
        } else {
            return find(input, output);
        }
    }

    protected abstract <I, O> Converter<I, O> find(TypeToken<? super I> input, TypeToken<O> output);

}
