package org.whiskeysierra.flux;


import org.junit.Assert;
import org.junit.Test;

public final class SilentFeatureTest {

    @Test
    public void testEnabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.SILENT));
        Assert.assertNull(capacitor.convert("12345").tryTo(Long.class).orNull());
    }

    @Test(expected = UnknownConversionException.class)
    public void testDisabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of());
        capacitor.convert("12345").tryTo(Long.class).get();
    }

}
