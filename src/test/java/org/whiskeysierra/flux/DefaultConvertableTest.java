package org.whiskeysierra.flux;

import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.converters.base.ObjectToStringConverter;
import org.whiskeysierra.flux.converters.collections.MapToConvertableMapConverter;
import org.whiskeysierra.flux.direct.DirectConverterMapping;

import java.util.Map;

public final class DefaultConvertableTest {

    @Test
    public void emptyMapping() {
        final ConverterMapping mapping = new DirectConverterMapping();
        final Conversion conversion = new DefaultConversion(mapping);
        final ConvertableFactory factory = new DefaultConvertableFactory(conversion);

        Assert.assertNull(factory.transform(new Object()).tryTo(String.class).orNull());
        Assert.assertEquals("value", factory.transform(new Object()).tryTo(String.class).or("value"));
    }

    @Test
    public void singleBinding() {
        final ConverterMapping mapping = new DirectConverterMapping();
        final Conversion conversion = new DefaultConversion(mapping);
        final ConvertableFactory factory = new DefaultConvertableFactory(conversion);

        mapping.register(new ObjectToStringConverter());

        final Object value = new Object();

        Assert.assertNotNull(factory.transform(value).tryTo(String.class).orNull());
        Assert.assertEquals(value.toString(), factory.transform(value).tryTo(String.class).or("value"));
    }

}
