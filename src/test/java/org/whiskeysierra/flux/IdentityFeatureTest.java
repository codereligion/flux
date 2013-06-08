package org.whiskeysierra.flux;


import org.junit.Assert;
import org.junit.Test;

public final class IdentityFeatureTest {

    @Test
    public void testEnabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.IDENTITY));
        Assert.assertEquals(12345L, (long) capacitor.convert(12345L).to(Long.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testDisabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of());
        capacitor.convert(12345L).to(Long.class);
    }

}
