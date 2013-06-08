package org.whiskeysierra.flux;

import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.converters.base.ObjectToStringConverter;
import org.whiskeysierra.flux.converters.primitives.StringToLongConverter;

public class TransitiveFeatureTest {

    @Test
    public void testEnabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.TRANSITIVE), new Bundle() {
            @Override
            public void configure(Convert convert) {
                convert.using(new ObjectToStringConverter());
                convert.using(new StringToLongConverter());
            }
        });

        Assert.assertEquals(12345L, (long) capacitor.convert("12345", Object.class).to(Long.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testDisabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(), new Bundle() {
            @Override
            public void configure(Convert convert) {
                convert.using(new ObjectToStringConverter());
                convert.using(new StringToLongConverter());
            }
        });

        capacitor.convert("12345", Object.class).to(Long.class);
    }

}
