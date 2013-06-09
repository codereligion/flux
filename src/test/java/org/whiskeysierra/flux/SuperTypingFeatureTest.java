package org.whiskeysierra.flux;

import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.converters.wrappers.StringToLongConverter;

public class SuperTypingFeatureTest {

    @Test
    public void testEnabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.SUPER_TYPING),
            new Bundle() {
                @Override
                public void configure(Convert convert) {
                    convert.using(new StringToLongConverter());
                }
            });

        Assert.assertEquals(12345L, capacitor.convert("12345").to(Number.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testDisabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(),
            new Bundle() {
                @Override
                public void configure(Convert convert) {
                    convert.using(new StringToLongConverter());
                }
            });

        capacitor.convert("12345").to(Number.class);
    }

}
