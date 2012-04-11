package org.whiskeysierra.flux;

import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.converters.ObjectToStringConverter;

import java.util.Map;

public final class DefaultConvertableTest {

    @Test
    public void emptyMapping() {
        final ConverterMapping mapping = new DefaultConverterMapping();
        final ConvertableFactory factory = new DefaultConvertableFactory(mapping);
        final Map<String, Object> original = Maps.newHashMap();
        final Map<String, Convertable> map = factory.transform(original);

        Assert.assertNull(map.get("key").tryTo(String.class).orNull());
        Assert.assertEquals("value", map.get("key").tryTo(String.class).or("value"));
    }

    @Test
    public void singleBinding() {
        final ConverterMapping mapping = new DefaultConverterMapping();

        mapping.register(Object.class, String.class, new ObjectToStringConverter());

        final ConvertableFactory factory = new DefaultConvertableFactory(mapping);
        final Map<String, Object> original = Maps.newHashMap();

        final Object value = new Object();
        original.put("key", value);

        final Map<String, Convertable> map = factory.transform(original);

        Assert.assertEquals(value.toString(), map.get("key").to(String.class));
        Assert.assertEquals(value.toString(), map.get("key").tryTo(String.class).orNull());

    }

}
