package org.whiskeysierra.flux;

import com.google.common.reflect.TypeToken;
import org.junit.Assert;
import org.junit.Test;
import org.whiskeysierra.flux.converters.BuiltInBundle;

import java.util.Arrays;
import java.util.List;

public final class IntegrationTest {

    private Capacitor unit() {
        return unit(Features.defaults());
    }

    private Capacitor unit(FeatureSet features) {
        return Flux.createCapacitor(features, new BuiltInBundle());
    }

    @Test
    public void raw() {
        final String expected = "12345";
        final Object actual = unit().convert(expected).raw();
        Assert.assertSame(expected, actual);
    }

    @Test
    public void cast() {
        final Object expected = "12345";
        final String actual = unit().convert(expected).cast(String.class);
        Assert.assertSame(expected, actual);
    }

    @Test
    public void castToken() {
        final Object expected = Arrays.asList("a", "b", "c");
        final List<String> actual = unit().convert(expected).cast(new TypeToken<List<String>>() {});
        Assert.assertSame(expected, actual);
    }

    @Test
    public void to() {
        final long value = unit().convert("12345").to(Long.class);
        Assert.assertEquals(12345L, value);
    }

    @Test
    public void toToken() {
        final long value = unit().convert("12345").to(new TypeToken<Long>() {});
        Assert.assertEquals(12345L, value);
    }

    @Test
    public void convertWithTypeHint() {
        final long value = unit().convert("12345", String.class).to(new TypeToken<Long>() {});
        Assert.assertEquals(12345L, value);
    }

    @Test
    public void convertWithTypeTokenHint() {
        final long value = unit().convert("12345", new TypeToken<String>() {}).to(new TypeToken<Long>() {});
        Assert.assertEquals(12345L, value);
    }

    @Test
    public void identity() {
        final Capacitor unit = unit(Features.of(Feature.IDENTITY));
        Assert.assertEquals(true, unit.convert(true).to(Boolean.class));
    }

}
