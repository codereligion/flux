package org.whiskeysierra.flux;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.spi.Converter;
import org.whiskeysierra.flux.spi.ConverterMapping;

import javax.annotation.Nullable;

class DefaultConversion implements Conversion {

    private final Capacitor capacitor;
    private final ConverterMapping mapping;
    private final FeatureSet features;

    public DefaultConversion(Capacitor capacitor, ConverterMapping mapping, FeatureSet features) {
        this.capacitor = Preconditions.checkNotNull(capacitor, "Capacitory");
        this.mapping = Preconditions.checkNotNull(mapping, "Mapping");
        this.features = Preconditions.checkNotNull(features, "Features");
    }

    @Override
    public <I, O> Optional<O> run(@Nullable I value, TypeToken<I> input, TypeToken<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");

        if (features.contains(Feature.IDENTITY) && input.isAssignableFrom(output)) {
            return Optional.fromNullable(this.<I, O>cast(value));
        } else {
            final Converter<I, O> converter = mapping.search(input, output);

            if (converter == null) {
                if (features.contains(Feature.SILENT)) {
                    return Optional.absent();
                } else {
                    throw new IllegalStateException(
                            String.format("No converter found for '%s -> %s'", input, output));
                }
            } else {
                return Optional.fromNullable(converter.convert(value, input, capacitor));
            }
        }
    }

    // guarded by TypeToken.equals(..)
    @SuppressWarnings("unchecked")
    private <I, O> O cast(I value) {
        return (O) value;
    }

}
