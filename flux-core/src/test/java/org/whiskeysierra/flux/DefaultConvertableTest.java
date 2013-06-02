package org.whiskeysierra.flux;

import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.converters.base.ObjectToStringConverter;
import org.whiskeysierra.flux.direct.DirectConverterMapping;
import org.whiskeysierra.flux.spi.ConverterMapping;

public final class DefaultConvertableTest {

    @Test
    public void emptyMapping() {
        final FeatureSet features = Features.defaults();
        final ConverterMapping mapping = new DirectConverterMapping(features);
        final Capacitor factory = new DefaultCapacitor(mapping, features);

        Assert.assertNull(factory.convert(new Object()).tryTo(String.class).orNull());
        Assert.assertEquals("value", factory.convert(new Object()).tryTo(String.class).or("value"));
    }

    @Test
    public void singleBinding() {
        final FeatureSet features = Features.of(Feature.SILENT);
        final ConverterMapping mapping = new DirectConverterMapping(features);
        mapping.register(new ObjectToStringConverter());

        final Capacitor capacitor = new DefaultCapacitor(mapping, features);

        final Object value = new Object();

        Assert.assertNotNull(capacitor.convert(value).tryTo(String.class).orNull());
        Assert.assertEquals(value.toString(), capacitor.convert(value).tryTo(String.class).or("value"));
    }

}
