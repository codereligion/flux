package org.codereligion.flux;

import com.codereligion.flux.Capacitor;
import com.codereligion.flux.ConversionException;
import com.codereligion.flux.Feature;
import com.codereligion.flux.Features;
import com.codereligion.flux.Flux;
import org.junit.Assert;
import org.junit.Test;
import com.codereligion.flux.converters.wrappers.StringToWrappersBundle;

public final class NoErrorFeatureTest {

    @Test
    public void testEnabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.NO_ERROR), new StringToWrappersBundle());
        Assert.assertNull(capacitor.convert("abc").tryTo(Long.class).orNull());
    }

    @Test(expected = ConversionException.class)
    public void testDisabled() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(), new StringToWrappersBundle());
        capacitor.convert("abc").tryTo(Long.class).get();
    }

}
