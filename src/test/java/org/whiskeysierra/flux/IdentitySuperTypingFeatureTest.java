package org.whiskeysierra.flux;


import org.junit.Assert;
import org.junit.Test;

public class IdentitySuperTypingFeatureTest {

    @Test
    public void testEnabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.IDENTITY, Feature.SUPER_TYPING));
        Assert.assertEquals(12345L, capacitor.convert(12345L).to(Number.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testNoIdentity() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.SUPER_TYPING));
        capacitor.convert(12345L).to(Number.class);
    }

    @Test(expected = UnknownConversionException.class)
    public void testNoSuperTyping() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.IDENTITY));
        capacitor.convert(12345L).to(Number.class);
    }

    @Test(expected = UnknownConversionException.class)
    public void testDisabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of());
        capacitor.convert(12345L).to(Number.class);
    }

}
