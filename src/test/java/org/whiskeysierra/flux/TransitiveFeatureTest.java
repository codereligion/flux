package org.whiskeysierra.flux;

import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.converters.base.BaseBundle;
import org.whiskeysierra.flux.converters.wrappers.StringToWrappersBundle;

public final class TransitiveFeatureTest {

    @Test
    public void testEnabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.TRANSITIVE),
            new StringToWrappersBundle(), new BaseBundle());

        Assert.assertEquals(12345L, (long) capacitor.convert("12345", Object.class).to(Long.class));
    }

    @Test(expected = UnknownConversionException.class)
    public void testDisabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(),
            new StringToWrappersBundle(), new BaseBundle());

        capacitor.convert("12345", Object.class).to(Long.class);
    }

}
