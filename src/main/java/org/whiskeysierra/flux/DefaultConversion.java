package org.whiskeysierra.flux;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.reflect.TypeToken;
import org.whiskeysierra.flux.internal.ConverterFinder;
import org.whiskeysierra.flux.spi.Converter;

import javax.annotation.Nullable;

class DefaultConversion implements Conversion {

    private final Capacitor capacitor;
    private final ConverterFinder finder;
    private final FeatureSet features;

    public DefaultConversion(Capacitor capacitor, ConverterFinder finder, FeatureSet features) {
        this.capacitor = Preconditions.checkNotNull(capacitor, "Capacitory");
        this.finder = Preconditions.checkNotNull(finder, "Finder");
        this.features = Preconditions.checkNotNull(features, "Features");
    }

    @Override
    public <I, O> Optional<O> run(@Nullable I value, TypeToken<I> input, TypeToken<O> output) {
        Preconditions.checkNotNull(input, "Input");
        Preconditions.checkNotNull(output, "Output");

        if (supportsIdentity(input, output)) {
            return Optional.fromNullable(this.<I, O>cast(value));
        } else {
            final Converter<I, O> converter = finder.search(input, output);

            if (converter == null) {
                if (features.contains(Feature.SILENT)) {
                    return Optional.absent();
                } else {
                    throw new UnknownConversionException(
                        String.format("No converter found for '%s -> %s'", input, output));
                }
            } else {
                try {
                    return Optional.fromNullable(converter.convert(value, input, capacitor));
                } catch (Exception e) {
                    if (features.contains(Feature.NO_ERROR)) {
                        return Optional.absent();
                    } else {
                        Throwables.propagateIfInstanceOf(e, ConversionException.class);
                        throw new ConversionException(e);
                    }
                }
            }
        }
    }

    private <I, O> boolean supportsIdentity(TypeToken<I> input, TypeToken<O> output) {
        if (features.contains(Feature.IDENTITY)) {
            if (features.contains(Feature.SUPER_TYPING)) {
                return output.isAssignableFrom(input);
            } else {
                return input.equals(output);
            }
        } else {
            return false;
        }
    }

    // guarded by TypeToken.equals(..)
    @SuppressWarnings("unchecked")
    private <I, O> O cast(I value) {
        return (O) value;
    }

}
