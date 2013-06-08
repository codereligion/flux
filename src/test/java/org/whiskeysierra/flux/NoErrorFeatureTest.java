package org.whiskeysierra.flux;

import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.converters.primitives.StringToLongConverter;

public final class NoErrorFeatureTest {

    @Test
    public void testEnabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.NO_ERROR), new Bundle() {

            @Override
            public void configure(Convert convert) {
                convert.using(new StringToLongConverter());
            }

        });

        Assert.assertNull(capacitor.convert("abc").tryTo(Long.class).orNull());
    }

    @Test(expected = ConversionException.class)
    public void testDisabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(), new Bundle() {

            @Override
            public void configure(Convert convert) {
                convert.using(new StringToLongConverter());
            }

        });

        capacitor.convert("abc").tryTo(Long.class).get();
    }

}
