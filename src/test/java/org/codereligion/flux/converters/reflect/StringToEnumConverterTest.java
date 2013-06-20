package org.codereligion.flux.converters.reflect;

import com.codereligion.flux.converters.reflect.ReflectBundle;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import com.codereligion.flux.Capacitor;
import com.codereligion.flux.Flux;

import java.util.concurrent.TimeUnit;

public final class StringToEnumConverterTest {

    @Ignore("Until we find a way to support something like StringToEnumConverter")
    @Test
    public void testConvert() {
        final Capacitor capacitor = Flux.createCapacitor(new ReflectBundle());
        Assert.assertEquals(TimeUnit.DAYS, capacitor.convert("DAYS").to(TimeUnit.class));
    }

}
