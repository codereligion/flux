package org.codereligion.flux;

import com.codereligion.flux.Capacitor;
import com.codereligion.flux.Feature;
import com.codereligion.flux.Features;
import com.codereligion.flux.Flux;
import com.codereligion.flux.UnknownConversionException;
import org.junit.Assert;
import org.junit.Test;
import com.codereligion.flux.converters.base.BaseBundle;

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
