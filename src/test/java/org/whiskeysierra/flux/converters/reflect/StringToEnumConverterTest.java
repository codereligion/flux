package org.whiskeysierra.flux.converters.reflect;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.whiskeysierra.flux.Capacitor;
import org.whiskeysierra.flux.Flux;

import java.util.concurrent.TimeUnit;

public final class StringToEnumConverterTest {

    @Ignore("Until we find a way to support something like StringToEnumConverter")
    @Test
    public void testConvert() {
        final Capacitor capacitor = Flux.createCapacitor(new ReflectBundle());
        Assert.assertEquals(TimeUnit.DAYS, capacitor.convert("DAYS").to(TimeUnit.class));
    }

}
