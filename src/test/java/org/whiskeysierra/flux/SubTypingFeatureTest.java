package org.whiskeysierra.flux;

import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.converters.base.BaseBundle;

public final class SubTypingFeatureTest {

    @Test
    public void testEnabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.SUB_TYPING), new BaseBundle());
        Assert.assertEquals("12345", capacitor.convert(12345L).to(String.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testDisabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(), new BaseBundle());
        capacitor.convert(12345L).to(String.class);
    }

}
