package org.whiskeysierra.flux.direct;

import com.google.common.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.ConversionContext;
import org.whiskeysierra.flux.Converter;
import org.whiskeysierra.flux.ConverterMapping;
import org.whiskeysierra.flux.converters.base.ObjectToStringConverter;

import javax.annotation.Nullable;
import java.util.List;

public final class DirectConverterMappingTest {

    @Test
    public void simpleBinding() {
        final ConverterMapping mapping = new DirectConverterMapping();

        final Converter<Object, String> converter = new ObjectToStringConverter();

        final TypeToken<Object> input = TypeToken.of(Object.class);
        final TypeToken<String> output = TypeToken.of(String.class);

        mapping.register(converter);

        Assert.assertSame(converter, mapping.search(input, output));
    }

    @Test
    public void genericBinding() {
        final ConverterMapping mapping = new DirectConverterMapping();

        final Converter<String, List<String>> converter = new Converter<String, List<String>>() {

            @Override
            public List<String> convert(@Nullable String input, ConversionContext context) {
                throw new UnsupportedOperationException();
            }

        };

        mapping.register(converter);

        final TypeToken<String> input = TypeToken.of(String.class);
        final TypeToken<List<String>> output = new TypeToken<List<String>>() {
        };

        Assert.assertSame(converter, mapping.search(input, output));
    }

}
