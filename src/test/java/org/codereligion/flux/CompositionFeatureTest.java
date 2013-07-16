package org.codereligion.flux;

import com.codereligion.flux.Capacitor;
import com.codereligion.flux.Feature;
import com.codereligion.flux.Features;
import com.codereligion.flux.Flux;
import com.codereligion.flux.UnknownConversionException;
import org.junit.Assert;
import org.junit.Test;
import com.codereligion.flux.converters.base.BaseBundle;
import com.codereligion.flux.converters.wrappers.StringToWrappersBundle;

public final class CompositionFeatureTest {

    @Test
    public void testEnabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.COMPOSITION),
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
