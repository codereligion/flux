package org.whiskeysierra.flux;

import com.google.common.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.converters.ObjectToStringConverter;

public final class DefaultConverterMappingTest {

    @Test
    public void register() {
        final ConverterMapping mapping = new DefaultConverterMapping();

        final Converter<Object, String> converter = new ObjectToStringConverter();

        final TypeToken<Object> input = TypeToken.of(Object.class);
        final TypeToken<String> output = TypeToken.of(String.class);

        mapping.register(input, output, converter);

        Assert.assertSame(converter, mapping.search(input, output));
    }

}
