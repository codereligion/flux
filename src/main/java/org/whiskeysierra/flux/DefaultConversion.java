package org.whiskeysierra.flux;

import com.google.common.reflect.TypeToken;

public class DefaultConversion implements Conversion {

    private final ConverterMapping mapping;

    public DefaultConversion(ConverterMapping mapping) {
        this.mapping = mapping;
    }

    @SuppressWarnings("unchecked")
    private <I> TypeToken<I> cast(TypeToken<?> token) {
        return (TypeToken<I>) token;
    }

    @Override
    public <I, O> O run(I value, TypeToken<O> output) {
        final TypeToken<I> input = cast(TypeToken.of(value.getClass()));
        final Converter<I, O> converter = mapping.search(input, output);

        if (converter == null) {
            return null;
        } else {
            return converter.convert(value, NoopConversionContext.INSTANCE);
        }
    }

}
