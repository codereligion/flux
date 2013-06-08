package org.whiskeysierra.flux;


import org.junit.Assert;

public class SilentFeatureTest extends FeatureTest {

    @Override
    public void testEnabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.SILENT));
        Assert.assertNull(capacitor.convert("12345").tryTo(Long.class).orNull());
    }

    @Override
    public void testDisabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of());
        capacitor.convert("12345").tryTo(Long.class).get();
    }

}
