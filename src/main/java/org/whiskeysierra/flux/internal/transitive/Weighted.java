package org.whiskeysierra.flux.internal.transitive;

import com.google.common.base.Preconditions;
import org.apache.commons.collections15.Transformer;
import org.whiskeysierra.flux.spi.Converter;

final class Weighted {

    public static final Transformer<Weighted, Number> TRANSFORMER = new Transformer<Weighted, Number>() {

        @Override
        public Number transform(Weighted weighted) {
            return weighted.getWeight();
        }

    };

    private final Converter<?, ?> converter;
    private final int weight;

    private Weighted(Converter<?, ?> converter, int weight) {
        this.converter = Preconditions.checkNotNull(converter, "Converter");
        this.weight = weight;
    }

    int getWeight() {
        return weight;
    }

    public static Weighted of(Converter<?, ?> converter, int weight) {
        return new Weighted(converter, weight);
    }

    @SuppressWarnings("unchecked")
    <I, O> Converter<I, O> getConverter() {
        return (Converter<I, O>) converter;
    }

}
