package org.whiskeysierra.flux;

import com.google.common.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Nullable;

public final class DefaultConverterMappingTest {

    @Test
    public void register() {
        final ConverterMapping mapping = new DefaultConverterMapping();

        final Converter<Object, Object> converter = new Converter<Object, Object>() {
            public Object convert(@Nullable Object input) {
                return null;
            }
        };

        final TypeToken<Object> input = TypeToken.of(Object.class);
        final TypeToken<Object> output = TypeToken.of(Object.class);

        mapping.register(input, output, converter);

        Assert.assertSame(converter, mapping.search(input, output));
    }

}
