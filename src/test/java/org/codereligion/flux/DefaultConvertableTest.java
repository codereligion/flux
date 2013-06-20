package org.codereligion.flux;

import com.codereligion.flux.Capacitor;
import com.codereligion.flux.Feature;
import com.codereligion.flux.Features;
import com.codereligion.flux.Flux;
import org.junit.Assert;
import org.junit.Test;
import com.codereligion.flux.converters.base.BaseBundle;

public final class DefaultConvertableTest {

    @Test
    public void emptyMapping() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.SILENT));

        Assert.assertNull(capacitor.convert(new Object()).tryTo(String.class).orNull());
        Assert.assertEquals("value", capacitor.convert(new Object()).tryTo(String.class).or("value"));
    }

    @Test
    public void singleBinding() {
        final Capacitor capacitor = Flux.createCapacitor(Features.of(Feature.SILENT), new BaseBundle());
        final Object value = new Object();

        Assert.assertNotNull(capacitor.convert(value).tryTo(String.class).orNull());
        Assert.assertEquals(value.toString(), capacitor.convert(value).tryTo(String.class).or("value"));
    }

}
